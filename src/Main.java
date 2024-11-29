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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame("Menu Principal");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(300, 200);
            mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));

            JButton listarButton = new JButton("Listar Estoque");
            JButton criarButton = new JButton("Criar Produto");
            JButton deletarButton = new JButton("Deletar Produto");
            JButton alterarButton = new JButton("Alterar Produto");
            JButton buscarButton = new JButton("Buscar Produto");
            JButton shutdownButton = new JButton("Sair do Sistema");

            listarButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            criarButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            deletarButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            alterarButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            buscarButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            shutdownButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

            Insets buttonMargin = new Insets(10, 20, 10, 20);
            listarButton.setMargin(buttonMargin);
            criarButton.setMargin(buttonMargin);
            deletarButton.setMargin(buttonMargin);
            alterarButton.setMargin(buttonMargin);
            buscarButton.setMargin(buttonMargin);
            shutdownButton.setMargin(buttonMargin);

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

            criarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame criarProdutoFrame = new CriarProdutoFrame();
                    criarProdutoFrame.setVisible(true);
                }
            });

            shutdownButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            mainFrame.add(listarButton);
            mainFrame.add(criarButton);
            mainFrame.add(deletarButton);
            mainFrame.add(alterarButton);
            mainFrame.add(buscarButton);
            mainFrame.add(shutdownButton);

            mainFrame.setVisible(true);
        });
    }
}
