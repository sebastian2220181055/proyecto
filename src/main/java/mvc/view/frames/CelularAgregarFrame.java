package mvc.view.frames;

import mvc.controller.ControllerForCelular;
import mvc.model.client.Mobile;
import mvc.view.celular.CelularInfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelularAgregarFrame extends JFrame implements ActionListener
{
    static Mobile mobile;
    private static final String AGREGAR = "Agregar";
    private static final String CANCELAR = "Cancelar";

    private JLabel jlbId;
    private JLabel jlblMarca;
    private JLabel jlblModelo;
    private JLabel jlblPrecio;
    private JLabel jlbStock;
    private JLabel jlbDescripcion;
    private JLabel jlblTitle;

    private JTextField txtId;
    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JTextField txtDescripcion;

    private JButton btnAgregar;
    private JButton btnCancelar;

    private JPanel infoPanel;
    private JPanel btnPanel;

    public CelularAgregarFrame() {

        setTitle("Agregar Celular");
        setLayout(new BorderLayout());
        setSize( 350, 250 );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setLocationRelativeTo(null);
        setResizable(false);

        Font font = new Font("Arial", 2, 16);
        Font fontTxt = new Font("Arial", 2, 16);

        //Titulo
        jlblTitle = new JLabel("AGREGAR CELULAR", SwingConstants.CENTER);
        jlblTitle.setFont(new Font("Arial", 2, 22));
        add(jlblTitle, BorderLayout.NORTH);

        //JPanel FLowLayout
        infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout());

        add(infoPanel, BorderLayout.CENTER);

        //Info
        //Info x2
        jlbId = new JLabel("    Id ");
        jlbId.setFont(font);

        jlblMarca = new JLabel("    Marca       ");
        jlblMarca.setFont(font);

        jlblModelo = new JLabel("   Modelo          ");
        jlblModelo.setFont(font);

        jlblPrecio = new JLabel("   Precio");
        jlblPrecio.setFont(font);

        jlbStock = new JLabel("     Precio");
        jlbStock.setFont(font);

        jlbDescripcion = new JLabel("Descripcion");
        jlbDescripcion.setFont(font);

        txtId = new JTextField();
        txtId.setFont(fontTxt);
        txtId.setPreferredSize(new Dimension( 200, 30 ) );
        txtId.setEditable(true);

        txtMarca = new JTextField();
        txtMarca.setPreferredSize(new Dimension( 200, 30 ) );
        txtMarca.setFont(fontTxt);
        txtMarca.setEditable(true);

        txtModelo = new JTextField();
        txtModelo.setFont(fontTxt);
        txtModelo.setPreferredSize(new Dimension( 200, 30 ) );
        txtModelo.setEditable(true);

        txtPrecio = new JTextField();
        txtPrecio.setFont(fontTxt);
        txtPrecio.setPreferredSize(new Dimension( 200, 30 ) );
        txtPrecio.setEditable(true);

        txtStock = new JTextField();
        txtStock.setFont(fontTxt);
        txtStock.setPreferredSize(new Dimension( 200, 30 ) );
        txtStock.setEditable(true);

        txtDescripcion = new JTextField();
        txtDescripcion.setFont(fontTxt);
        txtDescripcion.setPreferredSize(new Dimension( 200, 30 ) );
        txtDescripcion.setEditable(true);

        infoPanel.add(jlbId);
        infoPanel.add(txtId);

        infoPanel.add(jlblMarca);
        infoPanel.add(txtMarca);

        infoPanel.add(jlblModelo);
        infoPanel.add(txtModelo);

        infoPanel.add(jlblPrecio);
        infoPanel.add(txtPrecio);

        infoPanel.add(jlbStock);
        infoPanel.add(txtStock);

        //JPanel FLowLayout
        btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(1,2));

        add(btnPanel, BorderLayout.SOUTH);

        //Botones
        btnAgregar = new JButton( "Agregar" );
        btnAgregar.setActionCommand(AGREGAR);
        btnAgregar.addActionListener( this );

        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand(CANCELAR);
        btnCancelar.addActionListener( this );

        btnPanel.add(btnAgregar);
        btnPanel.add(btnCancelar);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();

        if(AGREGAR.equals(comando))
        {
            mobile = new Mobile(Integer.parseInt(txtId.getText()),
                    txtMarca.getText(),txtModelo.getText(), Integer.parseInt(txtPrecio.getText()), txtStock.getText(), txtDescripcion.getText());
            System.out.println(mobile.toString());
            CelularInfoPanel.limpiar();
            CelularInfoPanel.agregarALista(mobile);
            CelularInfoPanel.llenarCombobox();
            ControllerForCelular.ControllerForAddCelular(mobile);
            JOptionPane.showMessageDialog(null,"El Celular Ha Sido Agregado");
            dispose();

        }
        else if( CANCELAR.equals( comando ) )
        {
            JOptionPane.showMessageDialog(null,"Cancelado");
            dispose();
        }

    }
}

