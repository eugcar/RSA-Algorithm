/**
 * 
 */
package com.RSA.view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.RSA.model.algoritmoRSA.Client;

/**
 * @author Home
 *
 */
public class VHome extends JFrame {

	/**
	 * Seriale del frame.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Client.
	 */
	private Client _Bob, _Alice;
	/**
	 * Panel.
	 */
	private JPanel _contentPane, _pnlBob, _pnlBobInizializzato, _pnlEve, _pnlEveInizializzato, _pnlAlice, _pnlAliceInizializzato;
	/**
	 * ScrollPane
	 */
	private JScrollPane _scrollPaneBobInizializzato, _scrollPaneAliceInizializzato;
	/**
	 * Gestore del layout del contentPane.
	 */
	private GridLayout _layoutContentPane;
	/**
	 * Gestori dei layout dei client.
	 */
	private CardLayout _layoutBob, _layoutAlice;
	/**
	 * Istanza unica della classe - Pattern singleton
	 */
	private static VHome _instance = null;
	
	/**
	 * Metodo per ottenere l'unica istanza di questa classe - Pattern Singleton
	 */
	public static VHome getInstance() {
		if(_instance == null) {
            _instance = new VHome();
         }
         return _instance;
	}
	
	/**
	 * Costruttore
	 */
	private VHome() {
		super();
		// Setto il titolo
		setTitle("Algoritmo RSA");
		// Creo il contentPane
		_contentPane = this.CreaContentPane();
		// Aggiungo il contentPane al Frame
		setContentPane(_contentPane);
		// Non permetto il resize della finestra
		setResizable(false);
		// Operazione di default in chiusura.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Ricavo le dimensioni dello schermo.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// Prendo l'80% della larghezza dello schermo.
		int widthDesktop = (int) screenSize.getWidth();
		int widthFrame = (int) ((int) widthDesktop*0.8);
		// Prendo l'80% dell'altezza dello schermo.
		int heightDesktop = (int) screenSize.getHeight();
		int heightFrame = (int) ((int) heightDesktop*0.8);
		// Posizione iniziale
		int x_position = (int) ((int) widthDesktop*0.1);
		int y_position = (int) ((int) heightDesktop*0.1);
		// Imposto la posizione e la dimensione della finestra (x,y,width,height)
		setBounds(x_position, y_position, widthFrame, heightFrame);	
		// Mostro il frame
		this.setVisible(true);
	}
	/**
	 * Metodo per creare il panel relativo al contentPane.
	 */
	private JPanel CreaContentPane() {
		// Inizializzo il _contentPane
		_contentPane = new JPanel();
		// Setto il bordo al contentPane
		_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Setto il layout al contentPane
		_layoutContentPane = new GridLayout(1,3,0,5);
		_contentPane.setLayout(_layoutContentPane);
		// Aggiungo i pannelli al contentPane.
		_contentPane.add(creaPanelBaseBob());
		_contentPane.add(creaPanelBaseEve());
		_contentPane.add(creaPanelBaseAlice());
		
		return _contentPane;
	}
	/**
	 * Pannello per creare il pannello relativo a Bob.
	 * 
	 * @return Pannello relativo a Bob.
	 */
	private JPanel creaPanelBaseBob() {
		_pnlBob = new JPanel();
		// Assegno il gestore del layout
		_layoutBob = new CardLayout();
		_pnlBob.setLayout(_layoutBob);
		// Creo il primo pannello per il cardLayout.
		_pnlBob.add(this.creaPannelloInizializzazione("Bob"));
		
		return _pnlBob;
	}
	/**
	 * Metodo per aggiungere una scheda al pannello di Bob
	 * 
	 * @param Bob Client Bob.
	 */
	public void creaPanelInizializzatoBob(Client Bob) {
		// Setto Bob come attributo della finestra
		_Bob = Bob;
		// Creo lo scrollPane
		_scrollPaneBobInizializzato = new JScrollPane();
		// Creo il pannello
		_pnlBobInizializzato = new JPanel();
		// Setto il gestore del layout
		_pnlBobInizializzato.setLayout(new GridLayout(10, 1, 0, 5));
		// Creo elementi del pannello
		JLabel lbl_N = new JLabel("n: " + _Bob.get_publicKey().get_n().toString());
		JLabel lbl_E = new JLabel("e: " + _Bob.get_publicKey().get_e().toString());
		JLabel lbl_P = new JLabel("p: " + _Bob.get_privateKey().get_p().toString());
		JLabel lbl_Q = new JLabel("q: " + _Bob.get_privateKey().get_q().toString()); 
		JLabel lbl_D = new JLabel("d: " + _Bob.get_privateKey().get_d().toString());
		// Aggiungo elementi al pannello.
		_pnlBobInizializzato.add(new JLabel("Public Key:"));
		_pnlBobInizializzato.add(lbl_N);
		_pnlBobInizializzato.add(lbl_E);
		_pnlBobInizializzato.add(new JLabel("Private Key:"));
		_pnlBobInizializzato.add(lbl_P);
		_pnlBobInizializzato.add(lbl_Q);
		_pnlBobInizializzato.add(lbl_D);
		
		// Setto il campo visibile dello scrollPane in base al pnlBobInizializzato
		_scrollPaneBobInizializzato.setViewportView(_pnlBobInizializzato);
		
		// Aggiungo lo scrollPane al pnlBob
		_pnlBob.add(_scrollPaneBobInizializzato);
		// Cambio scheda
		_layoutBob.next(_pnlBob);
		
	}
	/**
	 * Metodo per creare il pannello relativo ad Eve.
	 * 
	 * @return Pannello relativo ad Eve.
	 */
	private JPanel creaPanelBaseEve() {
		_pnlEve = new JPanel();
		
		return _pnlEve;
	}
	
	/**
	 * Metodo per creare il pannello relativo ad Alice.
	 * 
	 * @return Pannello relativo ad Alice.
	 */
	private JPanel creaPanelBaseAlice() {
		_pnlAlice = new JPanel();
		// Assegno il gestore del layout
		_layoutAlice = new CardLayout();
		_pnlAlice.setLayout(_layoutAlice);
		// Creo il primo pannello per il cardLayout.
		_pnlAlice.add(this.creaPannelloInizializzazione("Alice"));
		
		return _pnlAlice;
	}
	/**
	 * Metodo per aggiungere una scheda al pannello di Alice.
	 * 
	 * @param Alice Client Alice.
	 */
	public void creaPanelInizializzatoAlice(Client Alice) {
		// Setto Alice come attributo della finestra
		_Alice = Alice;
		// Creo lo scrollPane
		_scrollPaneAliceInizializzato = new JScrollPane();
		// Creo il pannello
		_pnlAliceInizializzato = new JPanel();
		// Setto il gestore del layout
		_pnlAliceInizializzato.setLayout(new GridLayout(10, 1, 0, 5));
		// Creo elementi del pannello
		JLabel lbl_N = new JLabel("n: " + _Alice.get_publicKey().get_n().toString());
		JLabel lbl_E = new JLabel("e: " + _Alice.get_publicKey().get_e().toString());
		JLabel lbl_P = new JLabel("p: " + _Alice.get_privateKey().get_p().toString());
		JLabel lbl_Q = new JLabel("q: " + _Alice.get_privateKey().get_q().toString()); 
		JLabel lbl_D = new JLabel("d: " + _Alice.get_privateKey().get_d().toString());
		// Aggiungo elementi al pannello.
		_pnlAliceInizializzato.add(new JLabel("Public Key:"));
		_pnlAliceInizializzato.add(lbl_N);
		_pnlAliceInizializzato.add(lbl_E);
		_pnlAliceInizializzato.add(new JLabel("Private Key:"));
		_pnlAliceInizializzato.add(lbl_P);
		_pnlAliceInizializzato.add(lbl_Q);
		_pnlAliceInizializzato.add(lbl_D);
		
		// Setto il campo visibile dello scrollPane in base al _pnlAliceInizializzato
		_scrollPaneAliceInizializzato.setViewportView(_pnlAliceInizializzato);
		
		// Aggiungo lo scrollPane al _pnlAlice.
		_pnlAlice.add(_scrollPaneAliceInizializzato);
		// Cambio scheda
		_layoutAlice.next(_pnlAlice);
	}
	/**
	 * Metodo per creare un pannello contenente un bottone per inizializzare il client.
	 * 
	 * @return Pannello contenente un bottone per inizializzare il client.
	 */
	private JPanel creaPannelloInizializzazione(String nomeClient) {
		JPanel pnlInizializzazione = new JPanel();
		// Layout panello
		pnlInizializzazione.setLayout(new GridLayout(8, 1, 0, 5));
		// Creo il bottone
		JButton btnInizializzazione = new JButton("Inizializza " + nomeClient);
		// Aggiungo il listener dell'evento di inizializzazione.
		btnInizializzazione.addMouseListener(new InizializzaClientListener(nomeClient));
		// Aggiungo il bottone al pannello
		pnlInizializzazione.add(btnInizializzazione);
		
		return pnlInizializzazione;
	}
	
	
	
	
	
	/**
	 * @return the _Bob
	 */
	public Client get_Bob() {
		return _Bob;
	}
	/**
	 * @param _Bob the _Bob to set
	 */
	public void set_Bob(Client _Bob) {
		this._Bob = _Bob;
	}
	/**
	 * @return the _Alice
	 */
	public Client get_Alice() {
		return _Alice;
	}
	/**
	 * @param _Alice the _Alice to set
	 */
	public void set_Alice(Client _Alice) {
		this._Alice = _Alice;
	}
	/**
	 * @return the _pnlBob
	 */
	public JPanel get_pnlBob() {
		return _pnlBob;
	}
	/**
	 * @param _pnlBob the _pnlBob to set
	 */
	public void set_pnlBob(JPanel _pnlBob) {
		this._pnlBob = _pnlBob;
	}
	/**
	 * @return the _pnlAlice
	 */
	public JPanel get_pnlAlice() {
		return _pnlAlice;
	}
	/**
	 * @param _pnlAlice the _pnlAlice to set
	 */
	public void set_pnlAlice(JPanel _pnlAlice) {
		this._pnlAlice = _pnlAlice;
	}
}
