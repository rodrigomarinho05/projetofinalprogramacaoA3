import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main {
    static ArrayList<Produto> estoque = new ArrayList<>();
    static ArrayList<Fabrica> fabricas = new ArrayList<>();
    static ArrayList<Fornecedor> fornecedores = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame("Menu Principal");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(300, 200);
            mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));

            JButton criarButton = new JButton("Criar Produto");
            JButton listarButton = new JButton("Listar Estoque");
            JButton deletarButton = new JButton("Deletar Produto");
            JButton alterarButton = new JButton("Alterar Produto");
            JButton buscarButton = new JButton("Buscar Produto");

            JButton criarFabricaButton = new JButton("Criar Fabrica");
            JButton listarFabricasButton = new JButton("Listar Fabricas");
            JButton deletarFabricasButton = new JButton("Deletar Fabricas");
            JButton alterarFabricasButton = new JButton("Alterar Fabricas");
            JButton buscarFabricasButton = new JButton("Buscar Fabricas");

            JButton criarFornecedorButton = new JButton("Criar Forncecedor");
            JButton listarFornecedorButton = new JButton("Listar Forncecedores");
            JButton deletarFornecedorButton = new JButton("Deletar Forncecedor");
            JButton alterarFornecedorButton = new JButton("Alterar Forncecedor");
            JButton buscarFornecedorButton = new JButton("Buscar Forncecedores");

            JButton shutdownButton = new JButton("Sair do Sistema");

            listarButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            criarButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            deletarButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            alterarButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            buscarButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

            criarFabricaButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            listarFabricasButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            deletarFabricasButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            alterarFabricasButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            buscarFabricasButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

            criarFornecedorButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            listarFornecedorButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            deletarFornecedorButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            alterarFornecedorButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            buscarFornecedorButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

            shutdownButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

            Insets buttonMargin = new Insets(10, 20, 10, 20);
            criarButton.setMargin(buttonMargin);
            listarButton.setMargin(buttonMargin);
            deletarButton.setMargin(buttonMargin);
            alterarButton.setMargin(buttonMargin);
            buscarButton.setMargin(buttonMargin);
            
            criarFabricaButton.setMargin(buttonMargin);
            listarFabricasButton.setMargin(buttonMargin);
            deletarFabricasButton.setMargin(buttonMargin);
            alterarFabricasButton.setMargin(buttonMargin);
            buscarFabricasButton.setMargin(buttonMargin);

            criarFornecedorButton.setMargin(buttonMargin);
            listarFornecedorButton.setMargin(buttonMargin);
            deletarFornecedorButton.setMargin(buttonMargin);
            alterarFornecedorButton.setMargin(buttonMargin);
            buscarFornecedorButton.setMargin(buttonMargin);

            shutdownButton.setMargin(buttonMargin);

            criarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame criarProdutoFrame = new CriarProdutoFrame();
                    criarProdutoFrame.setVisible(true);
                }
            });

            ActionListener estoqueCheckListener = e -> {
                if (estoque.isEmpty()) {
                    JOptionPane.showMessageDialog(mainFrame, "Estoque está vazio! Por favor crie um produto.");
                } else {
                    JButton sourceButton = (JButton) e.getSource();
                    JFrame targetFrame = null;
                    if (sourceButton == listarButton) {
                        targetFrame = new ListarEstoqueFrame();
                    } else if (sourceButton == deletarButton) {
                        targetFrame = new DeletarProdutoFrame();
                    } else if (sourceButton == alterarButton) {
                        targetFrame = new AlterarProdutoFrame();
                    } else if (sourceButton == buscarButton) {
                        targetFrame = new BuscarProdutoFrame();
                    }
                    if (targetFrame != null) {
                        targetFrame.setVisible(true);
                    }
                }
            };

            listarButton.addActionListener(estoqueCheckListener);
            deletarButton.addActionListener(estoqueCheckListener);
            alterarButton.addActionListener(estoqueCheckListener);
            buscarButton.addActionListener(estoqueCheckListener);

            criarFabricaButton.addActionListener(e -> {
                JFrame criarFabricaFrame = new CriarFabricaFrame();
                criarFabricaFrame.setVisible(true);
            });

            ActionListener fabricaCheckListener = e -> {
                if (fabricas.isEmpty()) {
                    JOptionPane.showMessageDialog(mainFrame, "Não existem fabricas! Por favor crie uma.");
                } else {
                    JButton sourceButton = (JButton) e.getSource();
                    JFrame targetFrame = null;
                    if (sourceButton == listarFabricasButton) {
                        targetFrame = new ListarFabricasFrame();
                    } else if (sourceButton == deletarFabricasButton) {
                        targetFrame = new DeletarFabricaFrame();
                    } else if (sourceButton == alterarFabricasButton) {
                        targetFrame = new AlterarProdutoFrame();
                    } else if (sourceButton == buscarFabricasButton) {
                        targetFrame = new BuscarFabricaFrame();
                    }
                    if (targetFrame != null) {
                        targetFrame.setVisible(true);
                    }
                }
            };

            listarFabricasButton.addActionListener(fabricaCheckListener);
            deletarFabricasButton.addActionListener(fabricaCheckListener);
            alterarFabricasButton.addActionListener(fabricaCheckListener);
            buscarFabricasButton.addActionListener(fabricaCheckListener);

            criarFornecedorButton.addActionListener(e -> {
                JFrame criarFabricaFrame = new CriarFornecedorFrame();
                criarFabricaFrame.setVisible(true);
            });

            ActionListener fornecedorCheckListener = e -> {
                if (fabricas.isEmpty()) {
                    JOptionPane.showMessageDialog(mainFrame, "Não existem fornecedores! Por favor crie um.");
                } else {
                    JButton sourceButton = (JButton) e.getSource();
                    JFrame targetFrame = null;
                    if (sourceButton == listarFornecedorButton) {
                        targetFrame = new ListarFornecedorFrame();
                    } else if (sourceButton == deletarFornecedorButton) {
                        targetFrame = new DeletarFornecedorFrame();
                    } else if (sourceButton == alterarFornecedorButton) {
                        targetFrame = new AlterarFornecedorFrame();
                    } else if (sourceButton == buscarFornecedorButton) {
                        targetFrame = new BuscarFornecedorFrame();
                    }
                    if (targetFrame != null) {
                        targetFrame.setVisible(true);
                    }
                }
            };

            listarFornecedorButton.addActionListener(fornecedorCheckListener);
            deletarFornecedorButton.addActionListener(fornecedorCheckListener);
            alterarFornecedorButton.addActionListener(fornecedorCheckListener);
            buscarFornecedorButton.addActionListener(fornecedorCheckListener);

            shutdownButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            mainFrame.add(criarButton);
            mainFrame.add(listarButton);
            mainFrame.add(deletarButton);
            mainFrame.add(alterarButton);
            mainFrame.add(buscarButton);

            mainFrame.add(criarFabricaButton);
            mainFrame.add(listarFabricasButton);
            mainFrame.add(deletarFabricasButton);
            mainFrame.add(alterarFabricasButton);
            mainFrame.add(buscarFabricasButton);

            mainFrame.add(criarFornecedorButton);
            mainFrame.add(listarFornecedorButton);
            mainFrame.add(deletarFornecedorButton);
            mainFrame.add(alterarFornecedorButton);
            mainFrame.add(buscarFornecedorButton);

            mainFrame.add(shutdownButton);

            mainFrame.setVisible(true);
        });
    }
}
