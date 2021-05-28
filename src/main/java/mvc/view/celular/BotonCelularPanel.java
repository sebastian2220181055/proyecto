package mvc.view.celular;

import mvc.controller.ControllerForCelular;
import mvc.model.client.Mobile;
import mvc.view.frames.CelularAgregarFrame;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonCelularPanel extends JPanel implements ActionListener
{
    private static final String AGREGAR_CELULAR = "AgregarCelular";

    private static final String BORRAR_CELULAR = "EliminarCelular";

    private static final String MODIFICAR_CELULAR = "ModificarCelular";

    private JButton agregarCelular;

    private JButton eliminarCelular;

    private JButton modificarCelular;

    private CelularAgregarFrame addFrame;

    public BotonCelularPanel(  )
    {
        setBorder( new CompoundBorder( new EmptyBorder(50, 20, 80, 20 ), new TitledBorder( "Opciones" ) ) );
        setLayout( new GridLayout( 3, 1 ));

        agregarCelular = new JButton( "Agregar Celular" );
        agregarCelular.setActionCommand(AGREGAR_CELULAR);
        agregarCelular.addActionListener( this );
        add(agregarCelular);

        eliminarCelular = new JButton( "Eliminar Celular" );
        eliminarCelular.setActionCommand(BORRAR_CELULAR);
        eliminarCelular.addActionListener( this );
        add(eliminarCelular);

        modificarCelular = new JButton( "Modificar Celular" );
        modificarCelular.setActionCommand(MODIFICAR_CELULAR);
        modificarCelular.addActionListener( this );
        add(modificarCelular);

    }

    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );
        Mobile facultyDto = new Mobile();

        if(AGREGAR_CELULAR.equals(comando))
        {
            addFrame = new CelularAgregarFrame();
            addFrame.setVisible(true);
        }
        else if( BORRAR_CELULAR.equals( comando ) )
        {
            int resp = JOptionPane.showConfirmDialog(null, "Esta Seguro Que Desea Eliminar el Celular?","Eliminar Celular", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if(resp == JOptionPane.YES_OPTION)
            {
                ControllerForCelular.ControllerForDeleteCelular(CelularInfoPanel.getId());
                JOptionPane.showMessageDialog(this, "Borrado");
                CelularInfoPanel.actualizarLista();
                CelularInfoPanel.limpiar();
                CelularInfoPanel.llenarCombobox();
            }
        }
        else if(MODIFICAR_CELULAR.equals(comando)){
            int resp = JOptionPane.showConfirmDialog(null, "Esta Seguro Que Desea Modificar el Celular?","Modificar Celular", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if(resp == JOptionPane.YES_OPTION)

            {
                CelularInfoPanel.actualizarCelular();
                JOptionPane.showMessageDialog(this, "Celular Actualizado");
                CelularInfoPanel.limpiar();
                CelularInfoPanel.llenarCombobox();

            }

        }

    }
}
