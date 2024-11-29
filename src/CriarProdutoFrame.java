import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CriarProdutoFrame extends JFrame {
    public CriarProdutoFrame() {
        setTitle("Criar Produto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();
        JLabel descricaoLabel = new JLabel("Descrição:");
        JTextField descricaoField = new JTextField();
        JLabel marcaLabel = new JLabel("Marca:");
        JTextField marcaField = new JTextField();
        JLabel modeloLabel = new JLabel("Modelo:");
        JTextField modeloField = new JTextField();
        JLabel anoLabel = new JLabel("Ano:");
        JTextField anoField = new JTextField();
        JLabel precoLabel = new JLabel("Preço:");
        JTextField precoField = new JTextField();
        JButton criarButton = new JButton("Criar");

        criarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String descricao = descricaoField.getText();
                String marca = marcaField.getText();
                String modelo = modeloField.getText();
                int ano = Integer.parseInt(anoField.getText());
                double preco = Double.parseDouble(precoField.getText());

                Produto novoProduto = new Peca(nome, descricao, marca, modelo, ano, preco);
                Main.estoque.add(novoProduto);
                JOptionPane.showMessageDialog(null, "Produto criado com sucesso!");
                dispose();
            }
        });

        add(nomeLabel);
        add(nomeField);
        add(descricaoLabel);
        add(descricaoField);
        add(marcaLabel);
        add(marcaField);
        add(modeloLabel);
        add(modeloField);
        add(anoLabel);
        add(anoField);
        add(precoLabel);
        add(precoField);
        add(new JLabel());
        add(criarButton);

        setVisible(true);
    }
}