import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SecondMain {
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

            listarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame listarEstoqueFrame = new ListarEstoqueFrame();
                    listarEstoqueFrame.setVisible(true);
                }
            });

            criarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame criarProdutoFrame = new CriarProdutoFrame();
                    criarProdutoFrame.setVisible(true);
                }
            });

            deletarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame deletarProdutoFrame = new DeletarProdutoFrame();
                    deletarProdutoFrame.setVisible(true);
                }
            });

            alterarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame alterarProdutoFrame = new AlterarProdutoFrame();
                    alterarProdutoFrame.setVisible(true);
                }
            });

            buscarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame buscarProdutoFrame = new BuscarProdutoFrame();
                    buscarProdutoFrame.setVisible(true);
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
