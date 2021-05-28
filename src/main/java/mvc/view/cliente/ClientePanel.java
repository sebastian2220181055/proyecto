package mvc.view.cliente;

import mvc.view.InterfaceCelular;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ClientePanel extends JPanel
{
    private BotonClientePanel botonClientePanel;
    private ClienteInfoPanel clienteInfoPanel;
    private InterfaceCelular principal;

    public ClientePanel(InterfaceCelular ventana)
    {
        principal = ventana;
        setLayout( new GridLayout( 1, 2 ));
        setBorder( new CompoundBorder( new EmptyBorder(5 , 5, 5, 5 ), new TitledBorder( "Cliente" ) ) );

        clienteInfoPanel = new ClienteInfoPanel();
        add(clienteInfoPanel);

        botonClientePanel = new BotonClientePanel();
        add(botonClientePanel);

    }
}
