package Interface;

import Controller.ProdutoController;
import Produto.Componente;
import Produto.Produto;
import Produto.ProdutoAcabado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prod_View {
    private ProdutoController controller;
    private JFrame frame;
    private JTable tableProdutos;
    private DefaultTableModel tableModel;

    public Prod_View() {
        controller = new ProdutoController();

        // Configuração da janela principal
        frame = new JFrame("Cadastro de Produtos");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configuração da tabela
        String[] colunas = {"Nome", "Preço", "Código Legado", "Tipo Material", "Importado", "Garantia", "Qtd Palete"};
        tableModel = new DefaultTableModel(colunas, 0);
        tableProdutos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableProdutos);

        // Botão para adicionar produto
        JButton btnAdicionar = new JButton("Adicionar Produto");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProduto();
            }
        });

        // Layout da janela
        frame.getContentPane().add(scrollPane, "Center");
        frame.getContentPane().add(btnAdicionar, "South");

        // Exibir janela
        frame.setVisible(true);
    }

    private void adicionarProduto() {
        // Opções para o usuário escolher o tipo de produto
        String[] opcoes = {"Componente", "Produto Acabado"};
        int escolha = JOptionPane.showOptionDialog(null, "Selecione o tipo de produto:", "Tipo de Produto",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == JOptionPane.CLOSED_OPTION) {
            return; // Usuário cancelou
        }

        JTextField nomeField = new JTextField(10);
        JTextField precoField = new JTextField(5);
        JTextField codigoLegadoField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Preço:"));
        panel.add(precoField);
        panel.add(new JLabel("Código Legado:"));
        panel.add(codigoLegadoField);

        // Se o usuário escolheu "Componente"
        if (escolha == 0) {
            JTextField tipoMaterialField = new JTextField(10);
            JCheckBox importadoCheckBox = new JCheckBox("Importado?");

            panel.add(new JLabel("Tipo Material:"));
            panel.add(tipoMaterialField);
            panel.add(importadoCheckBox);

            // Mostrar o diálogo
            int result = JOptionPane.showConfirmDialog(null, panel,
                    "Adicionar Componente", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                try {
                    String nome = nomeField.getText();
                    float preco = Float.parseFloat(precoField.getText());
                    String codigoLegado = codigoLegadoField.getText();
                    String tipoMaterial = tipoMaterialField.getText();
                    boolean importado = importadoCheckBox.isSelected();

                    // Criar um Componente e adicionar ao controller
                    Produto componente = new Componente(nome, preco, codigoLegado, tipoMaterial, importado);
                    controller.adicionarProduto(componente);

                    listarProdutos();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro no formato dos valores numéricos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else if (escolha == 1) { // Se o usuário escolheu "Produto Acabado"
            JTextField garantiaField = new JTextField(5);
            JTextField quantidadePaleteField = new JTextField(5);

            panel.add(new JLabel("Garantia (anos):"));
            panel.add(garantiaField);
            panel.add(new JLabel("Quantidade Palete:"));
            panel.add(quantidadePaleteField);

            // Mostrar o diálogo
            int result = JOptionPane.showConfirmDialog(null, panel,
                    "Adicionar Produto Acabado", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                try {
                    String nome = nomeField.getText();
                    float preco = Float.parseFloat(precoField.getText());
                    String codigoLegado = codigoLegadoField.getText();
                    int garantia = Integer.parseInt(garantiaField.getText());
                    int quantidadePalete = Integer.parseInt(quantidadePaleteField.getText());

                    // Criar um Produto Acabado e adicionar ao controller
                    Produto produtoAcabado = new ProdutoAcabado(nome, preco, codigoLegado, garantia, quantidadePalete);
                    controller.adicionarProduto(produtoAcabado);

                    listarProdutos();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro no formato dos valores numéricos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void listarProdutos() {
        // Limpar a tabela antes de listar os produtos
        tableModel.setRowCount(0);

        // Adicionar cada produto na tabela
        for (Produto produto : controller.listarProdutos()) {
            if (produto instanceof Componente) {
                Componente comp = (Componente) produto;
                Object[] linha = {
                        comp.getNome(),
                        comp.getPreco(),
                        comp.getCodigoLegado(),
                        comp.getTipoMaterial(),
                        comp.isImportado() ? "Sim" : "Não",
                        "-", "-"
                };
                tableModel.addRow(linha);
            } else if (produto instanceof ProdutoAcabado) {
                ProdutoAcabado prodAcabado = (ProdutoAcabado) produto;
                Object[] linha = {
                        prodAcabado.getNome(),
                        prodAcabado.getPreco(),
                        prodAcabado.getCodigoLegado(),
                        "-", "-",
                        prodAcabado.getGarantia(),
                        prodAcabado.getQuantidadePalete()
                };
                tableModel.addRow(linha);
            }
        }
    }

    public static void main(String[] args) {
        new Prod_View();
    }
}
