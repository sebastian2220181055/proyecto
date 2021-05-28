package mvc.view.frames;

import mvc.controller.ControllerForCelular;
import mvc.controller.ControllerForClient;
import mvc.controller.ControllerForCliente;
import mvc.model.client.Client;
import mvc.view.celular.CelularInfoPanel;
import mvc.view.cliente.ClienteInfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteAgregarFrame extends JFrame implements ActionListener
{
    static Client client;
    private static final String AGREGAR = "Agregar";
    private static final String CANCELAR = "Cancelar";

    private JLabel jlblCedula;
    private JLabel jlblNombre;
    private JLabel jlblApellido;
    private JLabel jlblEmail;
    private JLabel jlblTelefono;
    private JLabel jlblTipoUsuario;
    private JLabel jlblComprasRealizadas;
    private JLabel jlblTitle;

    private JTextField txtCedula;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEmail;
    private JTextField txtTelefono;
    private JTextField txtTipoUsuario;
    private JTextField txtComprasRealizadas;

    private JButton btnAgregar;
    private JButton btnCancelar;

    private JPanel infoPanel;
    private JPanel btnPanel;

    public ClienteAgregarFrame() {

        setTitle("Agregar Cliente");
        setLayout(new BorderLayout());
        setSize( 350, 400 );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setLocationRelativeTo(null);
        setResizable(false);

        Font font = new Font("Arial", 2, 16);
        Font fontTxt = new Font("Arial", 2, 16);

        //Titulo
        jlblTitle = new JLabel("AGREGAR CLIENTE", SwingConstants.CENTER);
        jlblTitle.setFont(new Font("Arial", 2, 22));
        add(jlblTitle, BorderLayout.NORTH);

        //JPanel FLowLayout
        infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout());

        add(infoPanel, BorderLayout.CENTER);

        //Info
        //Info x2
        jlblCedula = new JLabel("Cedula ");
        jlblCedula.setFont(font);

        jlblNombre = new JLabel("Nombre       ");
        jlblNombre.setFont(font);

        jlblApellido = new JLabel("Apellido          ");
        jlblApellido.setFont(font);

        jlblEmail = new JLabel("Email      ");
        jlblEmail.setFont(font);

        jlblTelefono = new JLabel("Telefono         ");
        jlblTelefono.setFont(font);

        jlblTipoUsuario = new JLabel("Tipo de Usuario");
        jlblTipoUsuario.setFont(font);

        jlblComprasRealizadas = new JLabel("Compras Realizadas ");
        jlblComprasRealizadas.setFont(font);


        txtCedula = new JTextField();
        txtCedula.setFont(fontTxt);
        txtCedula.setPreferredSize(new Dimension( 200, 30 ) );
        txtCedula.setEditable(true);

        txtNombre = new JTextField();
        txtNombre.setPreferredSize(new Dimension( 200, 30 ) );
        txtNombre.setFont(fontTxt);
        txtNombre.setEditable(true);

        txtApellido = new JTextField();
        txtApellido.setFont(fontTxt);
        txtApellido.setPreferredSize(new Dimension( 200, 30 ) );
        txtApellido.setEditable(true);

        txtEmail = new JTextField();
        txtEmail.setFont(fontTxt);
        txtEmail.setPreferredSize(new Dimension( 200, 30 ) );
        txtEmail.setEditable(true);

        txtTelefono = new JTextField();
        txtTelefono.setFont(fontTxt);
        txtTelefono.setPreferredSize(new Dimension( 200, 30 ) );
        txtTelefono.setEditable(true);

        txtTipoUsuario = new JTextField();
        txtTipoUsuario.setFont(fontTxt);
        txtTipoUsuario.setPreferredSize(new Dimension( 200, 30 ) );
        txtTipoUsuario.setEditable(true);

        txtComprasRealizadas = new JTextField();
        txtComprasRealizadas.setFont(fontTxt);
        txtComprasRealizadas.setPreferredSize(new Dimension( 200, 30 ) );
        txtComprasRealizadas.setEditable(true);

        infoPanel.add(jlblCedula);
        infoPanel.add(txtCedula);

        infoPanel.add(jlblNombre);
        infoPanel.add(txtNombre);

        infoPanel.add(jlblApellido);
        infoPanel.add(txtApellido);

        infoPanel.add(jlblEmail);
        infoPanel.add(txtEmail);

        infoPanel.add(jlblTelefono);
        infoPanel.add(txtTelefono);

        infoPanel.add(jlblTipoUsuario);
        infoPanel.add(txtTipoUsuario);

        infoPanel.add(jlblComprasRealizadas);
        infoPanel.add(txtComprasRealizadas);

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
            client = new Client(txtCedula.getText(),
                    txtNombre.getText(),txtApellido.getText(),txtEmail.getText(),Integer.parseInt(txtTelefono.getText()), txtTipoUsuario.getText(),Integer.parseInt(txtComprasRealizadas.getText()));
            ClienteInfoPanel.limpiar();
            ClienteInfoPanel.agregarALista(client);
            ClienteInfoPanel.llenarCombobox();
            ControllerForCliente.ControllerForAddClient(client);
            JOptionPane.showMessageDialog(null,"El cliente Ha Sido Agregado");
            dispose();

        }
        else if( CANCELAR.equals( comando ) )
        {
            JOptionPane.showMessageDialog(null,"Cancelado");
            dispose();
        }

    }
}

