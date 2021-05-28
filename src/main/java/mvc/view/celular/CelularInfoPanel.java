package mvc.view.celular;

import Container.LinkedQueue;
import mvc.controller.ControllerForCelular;
import mvc.model.client.Mobile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelularInfoPanel extends JPanel implements ActionListener
{
    private static final String CAMBIAR_CELULAR = "CambiarCelular";

    private JLabel jlblCelular;
    private JLabel jlblMarca;
    private JLabel jlblId;
    private JLabel jlblModelo;
    private JLabel jlblPrecio;
    private JLabel jlblStock;
    private JLabel jlblDescripcion;
    private JLabel blanco1;
    private JLabel blanco2;

    private static JComboBox comboCelulares;
    private static JTextField txtMarca;
    private static JTextField txtId;
    private static JTextField txtModelo;
    private static JTextField txtPrecio;
    private static JTextField txtStock;
    private static JTextField txtDescripcion;
    private static LinkedQueue<Mobile> lista = ControllerForCelular.ControllerForReadCelular();

    public CelularInfoPanel(){


        setLayout(new FlowLayout());
        Font font = new Font("Arial", 2, 16);
        Font fontTxt = new Font("Arial", 2, 16);

        jlblCelular = new JLabel("    Celular       ");
        jlblCelular.setFont(font);



        jlblMarca = new JLabel("    Marca         ");
        jlblMarca.setFont(font);

        jlblId = new JLabel("     Id             ");
        jlblId.setFont(font);

        jlblModelo = new JLabel("   Modelo        ");
        jlblModelo.setFont(font);

        jlblPrecio = new JLabel("    Precio        ");
        jlblPrecio.setFont(font);

        jlblStock = new JLabel("    Stock        ");
        jlblStock.setFont(font);

        jlblDescripcion = new JLabel("Descripcion  ");
        jlblDescripcion.setFont(font);

        blanco1 = new JLabel("                          ");
        blanco2 = new JLabel("                                             ");

        comboCelulares = new JComboBox( );
        comboCelulares.setEditable( false );
        comboCelulares.addActionListener( this );
        comboCelulares.setActionCommand(CAMBIAR_CELULAR);
        comboCelulares.setPreferredSize( new Dimension( 195, 30 ) );

        txtMarca = new JTextField();
        txtMarca.setPreferredSize(new Dimension( 200, 30 ) );
        txtMarca.setFont(fontTxt);
        txtMarca.setEditable(true);

        txtId = new JTextField();
        txtId.setFont(fontTxt);
        txtId.setPreferredSize(new Dimension( 200, 30 ) );
        txtId.setEditable(false);

        txtModelo = new JTextField();
        txtModelo.setPreferredSize(new Dimension( 200, 30 ) );
        txtModelo.setFont(fontTxt);
        txtModelo.setEditable(true);

        txtPrecio = new JTextField();
        txtPrecio.setPreferredSize(new Dimension( 200, 30 ) );
        txtPrecio.setFont(fontTxt);
        txtPrecio.setEditable(true);

        txtStock = new JTextField();
        txtStock.setPreferredSize(new Dimension( 200, 30 ) );
        txtStock.setFont(fontTxt);
        txtStock.setEditable(true);

        txtDescripcion = new JTextField();
        txtDescripcion.setPreferredSize(new Dimension( 200, 30 ) );
        txtDescripcion.setFont(fontTxt);
        txtDescripcion.setEditable(true);


        Mobile mobileDto = new Mobile();
        mobileDto.setIdCelular(2000);



        add(blanco1);
        add(blanco2);

        add(jlblCelular);
        add(comboCelulares);

        add(jlblMarca);
        add(txtMarca);

        add(jlblId);
        add(txtId);

        add(jlblModelo);
        add(txtModelo);

        add(jlblPrecio);
        add(txtPrecio);

        add(jlblStock);
        add(txtStock);

        add(jlblDescripcion);
        add(txtDescripcion);

        llenarCombobox();


    }

    public  static  void agregarALista(Mobile mobile) {

        lista.enqueue(mobile);
    }

    public static void llenarCombobox() {

        if(!lista.isEmpty()){
            for (int i = 0; i < lista.getSize(); i++) {
                comboCelulares.addItem(lista.dequeue(i).getMarca());
            }
        }
    }

    public static void limpiar(){
        comboCelulares.removeAllItems();
        txtMarca.setText("");
        txtId.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();

        if(CAMBIAR_CELULAR.equals(comando))
        {
            if(comboCelulares.getSelectedItem() != null)
            {
                String name = comboCelulares.getSelectedItem().toString();
                actualizarInfo(name);
              /*  ImageOfFaculty.setRuta(obtenerRuta());
                ImageOfFaculty.actualizarImagen();
                TeamInfoPanel.llenarCombobox();

               */
            }
        }
    }

    public String obtenerRuta() {
        String ruta = null;

        if (comboCelulares.getSelectedItem() != null) {
            String name = comboCelulares.getSelectedItem().toString();

            for (int i = 0; i < lista.getSize(); i++) {
                if (lista.dequeue(i).getMarca() == name){
                  //  ruta = lista.dequeue(i).getImageFaculty();
                }
            }
        }
        return  ruta;
    }
    public static void actualizarCelular()
    {
        Mobile mobile = new Mobile(Integer.parseInt(txtId.getText()),comboCelulares.getSelectedItem().toString(), txtModelo.getText(), Integer.parseInt(txtPrecio.getText()), txtMarca.getText(), txtDescripcion.getText());
        for (int i = 0; i < lista.getSize(); i++) {
            if(lista.dequeue(i).getMarca().equals(comboCelulares.getSelectedItem().toString())){
                lista.dequeue(i).setMarca(txtMarca.getText());
            }
        }
        ControllerForCelular.ControllerForUpdateCelular(mobile);
    }
    ///ComentarioOOOOO

    public static LinkedQueue<Mobile> actualizarLista(){
        return lista =  ControllerForCelular.ControllerForReadCelular();
    }

    public static void actualizarInfo (String name) {

        boolean encontro = false;
        for (int i = 0; i < lista.getSize() && !encontro; i++) {
            if(name.equals(lista.dequeue(i).getMarca())){
                txtId.setText(Integer.toString(lista.dequeue(i).getIdCelular()));
                txtMarca.setText(lista.dequeue(i).getMarca());
                encontro = true;
            }
        }
    }

    public static int getId(){
        return Integer.parseInt(txtId.getText());
    }

}
