package mvc.view.cliente;

import mvc.controller.ControllerForClient;
import mvc.controller.ControllerForCliente;
import mvc.model.client.Client;
import mvc.view.frames.ClienteAgregarFrame;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonClientePanel extends JPanel implements ActionListener
{
    private static final String ADD_CLIENTE = "AgregarCliente";

    private static final String DELETE_CLIENTE = "EliminarCliente";

    private static final String MODIFY_CLIENTE = "ModificarCliente";

    static Client client;

    private ClienteAgregarFrame addFrame;

    private ClienteInfoPanel clienteInfo;

    private JButton addCliente;

    private JButton deleteCliente;

    private JButton modifyCliente;


    public BotonClientePanel( )
    {
        setBorder( new CompoundBorder( new EmptyBorder( 20, 20, 110, 20 ), new TitledBorder( "Opciones" ) ) );
        setLayout( new GridLayout( 3, 1 ));

        addCliente = new JButton( "Agregar Cliente" );
        addCliente.setActionCommand(ADD_CLIENTE);
        addCliente.addActionListener( this );
        add(addCliente);

        deleteCliente = new JButton( "Eliminar Cliente" );
        deleteCliente.setActionCommand(DELETE_CLIENTE);
        deleteCliente.addActionListener( this );
        add(deleteCliente);

        modifyCliente = new JButton( "Modificar Cliente" );
        modifyCliente.setActionCommand(MODIFY_CLIENTE);
        modifyCliente.addActionListener( this );
        add(modifyCliente);
    }

    public void actionPerformed( ActionEvent evento ) {

        String comando = evento.getActionCommand();
        Client clientDto = new Client();

        if(ADD_CLIENTE.equals(comando))
        {
            addFrame = new ClienteAgregarFrame();
            addFrame.setVisible(true);
        }
        else if( DELETE_CLIENTE.equals( comando ) )
        {
            int resp = JOptionPane.showConfirmDialog(null, "Esta Seguro Que Desea Eliminar el Cliente?","Eliminar Cliente", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if(resp == JOptionPane.YES_OPTION)
            {
                ControllerForCliente.ControllerForDeleteClient(ClienteInfoPanel.getIdForDelete());
                JOptionPane.showMessageDialog(this, "Borrado");
                ClienteInfoPanel.actualizarLista();
                ClienteInfoPanel.limpiar();
                ClienteInfoPanel.llenarCombobox();
            }
        }
        else if( MODIFY_CLIENTE.equals( comando ) )
        {
            int resp = JOptionPane.showConfirmDialog(null, "Esta Seguro Que Desea Modificar el Cliente?","Modificar Cliente", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if(resp == JOptionPane.YES_OPTION)

            {

                ClienteInfoPanel.actualizarCliente();
                JOptionPane.showMessageDialog(this, "Cliente Actualizado");
                ClienteInfoPanel.limpiar();
                ClienteInfoPanel.llenarCombobox();

            }
        }
    }
}
