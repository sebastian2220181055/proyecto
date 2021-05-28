package mvc.view;

import mvc.controller.ControllerBuildObject;
import mvc.view.celular.CelularPanel;
import mvc.view.cliente.ClientePanel;

import javax.swing.*;
import java.awt.*;


public class InterfaceCelular extends JFrame
{
    private ControllerBuildObject builderObject;
    private CelularPanel celularPanel;
    private ClientePanel clientePanel;

    public InterfaceCelular()
    {
        setTitle("Venta De Celulares");
        setLayout( new GridLayout( 2, 2 ));
        setSize( 750, 710 );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setLocationRelativeTo(null);
        setResizable(false);


        celularPanel = new CelularPanel( this );
        celularPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
                "Celular", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Arial", 3, 20)));
        add(celularPanel );

        clientePanel = new ClientePanel( this );
        clientePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
                "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Arial", 3, 20)));
        add(clientePanel);


        setVisible( true );
    }
}
