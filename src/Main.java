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

            JButton shutdownButton = new JButton("Sair do Sistema");

            listarButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            criarButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            deletarButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            alterarButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            buscarButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

            criarFabricaButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

            shutdownButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

            Insets buttonMargin = new Insets(10, 20, 10, 20);
            criarButton.setMargin(buttonMargin);
            listarButton.setMargin(buttonMargin);
            deletarButton.setMargin(buttonMargin);
            alterarButton.setMargin(buttonMargin);
            buscarButton.setMargin(buttonMargin);
            
            listarFabricasButton.setMargin(buttonMargin);
            criarFabricaButton.setMargin(buttonMargin);
            deletarFabricasButton.setMargin(buttonMargin);
            alterarFabricasButton.setMargin(buttonMargin);
            buscarFabricasButton.setMargin(buttonMargin);

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
            mainFrame.add(shutdownButton);

            mainFrame.setVisible(true);
        });
    }
}
