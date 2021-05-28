package mvc.view.cliente;

import Container.LinkedQueue;
import mvc.controller.ControllerForCliente;
import mvc.model.client.Client;
import mvc.view.celular.CelularInfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteInfoPanel extends JPanel implements ActionListener {

    private static final String CAMBIAR_CLIENTE = "CambiarCliente";

    private JLabel jlblCedula;
    private JLabel jlblNombre;
    private JLabel jlblApellido;
    private JLabel jlblEmail;
    private JLabel jlblTelefono;
    private JLabel jlblTipoUsuario;
    private JLabel jlblComprasRealizadas;

    private static JComboBox comboClientes;
    private static JTextField txtCedula;
    private static JTextField txtNombre;
    private static JTextField txtApellido;
    private static JTextField txtEmail;
    private static JTextField txtTelefono;
    private static JTextField txtTipoUsuario;
    private static JTextField txtComprasRealizadas;

    private static LinkedQueue<Client> lista =  ControllerForCliente.ControllerForReadClient();

    public ClienteInfoPanel(){

        setLayout(new FlowLayout());

        Font font = new Font("Arial", 2, 16);
        Font fontTxt = new Font("Arial", 2, 14);


        jlblCedula = new JLabel("    Cedula       ");
        jlblCedula.setFont(font);

        jlblNombre = new JLabel("    Nombre     ");
        jlblNombre.setFont(font);


            jlblApellido = new JLabel("      Apellido    ");
        jlblApellido.setFont(font);

        jlblEmail = new JLabel("    Email         ");
        jlblEmail.setFont(font);

        jlblTelefono = new JLabel(" Telefono       ");
        jlblTelefono.setFont(font);

        jlblTipoUsuario = new JLabel("Tipo Usuario  ");
        jlblTipoUsuario.setFont(font);

        jlblComprasRealizadas = new JLabel("Compras       ");
        jlblComprasRealizadas.setFont(font);

        comboClientes = new JComboBox( );
        comboClientes.setEditable( false );
        comboClientes.addActionListener( this );
        comboClientes.setActionCommand( CAMBIAR_CLIENTE );
        comboClientes.setPreferredSize( new Dimension( 195, 27 ) );

        txtCedula = new JTextField();
        txtCedula.setFont(fontTxt);
        txtCedula.setPreferredSize(new Dimension( 195, 27  ));
        txtCedula.setEditable(false);

        txtNombre = new JTextField();
        txtNombre.setFont(fontTxt);
        txtNombre.setPreferredSize(new Dimension( 195, 27 ));
        txtNombre.setEditable(true);

        txtApellido = new JTextField();
        txtApellido.setFont(fontTxt);
        txtApellido.setPreferredSize(new Dimension( 195, 27  ));
        txtApellido.setEditable(true);

        txtEmail = new JTextField();
        txtEmail.setFont(fontTxt);
        txtEmail.setPreferredSize(new Dimension( 195, 27  ));
        txtEmail.setEditable(true);

        txtTelefono = new JTextField();
        txtTelefono.setFont(fontTxt);
        txtTelefono.setPreferredSize(new Dimension( 195, 27  ));
        txtTelefono.setEditable(true);

        txtTipoUsuario = new JTextField();
        txtTipoUsuario.setFont(fontTxt);
        txtTipoUsuario.setPreferredSize(new Dimension( 195, 27  ));
        txtTipoUsuario.setEditable(true);

        txtComprasRealizadas = new JTextField();
        txtComprasRealizadas.setFont(fontTxt);
        txtComprasRealizadas.setPreferredSize(new Dimension( 195, 27  ));
        txtComprasRealizadas.setEditable(true);

        add(jlblCedula);
        add(comboClientes);

        add(jlblNombre);
        add(txtNombre);

        add(jlblApellido);
        add(txtApellido);

        add(jlblEmail);
        add(txtEmail);

        add(jlblTelefono);
        add(txtTelefono);

        add(jlblTipoUsuario);
        add(txtTipoUsuario);

        add(jlblComprasRealizadas);
        add(txtComprasRealizadas);

        llenarCombobox();
    }

    public static void llenarCombobox() {

        if(comboClientes != null){
            limpiar();
            for (int i = 0; i < lista.getSize(); i++) {
                if(lista.dequeue(i).getCedula().equals(CelularInfoPanel.getId())){
                    comboClientes.addItem(lista.dequeue(i).getCedula());
                }
            }
        }
    }

    public static LinkedQueue<Client> actualizarLista(){
        return lista =  ControllerForCliente.ControllerForReadClient();
    }

    public static void limpiar(){
        comboClientes.removeAllItems();
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCedula.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();

        if(CAMBIAR_CLIENTE.equals(comando))
        {
            if(comboClientes.getSelectedItem() != null)
            {
                String name = comboClientes.getSelectedItem().toString();
                actualizarInfo(name);
            }
        }

    }

    public static void actualizarCliente()
    {
        Client client = new Client(txtNombre.getText(),txtApellido.getText(),txtEmail.getText(),txtComprasRealizadas.getText(),Integer.parseInt(txtCedula.getText()), comboClientes.getSelectedItem().toString(),
                 Integer.parseInt(txtTelefono.getText()));
        for (int i = 0; i < lista.getSize(); i++) {
            if(lista.dequeue(i).getNombre().equals(comboClientes.getSelectedItem().toString())){
                lista.dequeue(i).setTelefono(Integer.parseInt(txtTelefono.getText()));
                lista.dequeue(i).setTipoUsuario(txtTipoUsuario.getText());
            }
        }
        ControllerForCliente.ControllerForUpdateClient(client);
    }

    public  static  void agregarALista(Client playerDto) {
        lista.enqueue(playerDto);
    }


    public static void actualizarInfo (String name) {
        boolean encontro = false;
        for (int i = 0; i < lista.getSize() && !encontro; i++) {
            if(name.equals(lista.dequeue(i).getNombre())){
                txtComprasRealizadas.setText(Integer.toString(lista.dequeue(i).getComprasRealizadas()));
                txtTelefono.setText(Integer.toString(lista.dequeue(i).getTelefono()));
                txtTipoUsuario.setText(lista.dequeue(i).getTipoUsuario());

                encontro = true;
            }
        }
    }

    public static String getIdForDelete(){
        return (txtCedula.getText());
    }
}
