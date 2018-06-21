package wqwe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import wqwe.PortScanner.ScanResult;


public class PingRRT extends JFrame {
	
	JButton st;
	JButton ip;
	JTextArea t;
	JPanel p;
	JPanel p1;
	JPanel p2;
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JMenu m1;
	JMenu m2;
	JMenu m3;
	JMenu m4;
	JMenu m5;
	JMenu m6;
	String fixedip;
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	JComboBox<String> cb1;
	JComboBox<String> cb2;
	JList list1;
	JMenuBar mb;
	static DefaultTableModel jdtm;
	JTable jt;
	
	String titles[] = new String[] {"IP","Ping","Hostname","TTL","Ports"};
	
	
	InputStream is = null;
	BufferedReader br = null;
	
	public PingRRT() {
		super("Ping");
		jdtm = new DefaultTableModel(null, titles);
		jt =new JTable(jdtm);
		p= new JPanel(new GridLayout(2,1));
		p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		st = new JButton(" start");
		ip = new JButton("IP");
		tf1 = new JTextField(10);
		tf2 = new JTextField(10);
		tf3 = new JTextField(10);
		l1 = new JLabel("IP Range");
		l2 = new JLabel("to");
		l3 = new JLabel("Hostname");
		mb = new JMenuBar();
		m1 = new JMenu("Scan");
		m2 = new JMenu("Go to");
		m3 = new JMenu("Commands");
		m4 = new JMenu("Favorites");
		m5 = new JMenu("Tools");
		m6 = new JMenu("Help");
		
		JMenuItem  LoadFromfilesAction = new JMenuItem("Load from files");
		JMenuItem  exportAllAction = new JMenuItem("Export All ");
		JMenuItem  exportSelectionAction = new JMenuItem("Export selection...  ");
		JMenuItem  QuitAction = new JMenuItem(" Quit ");
		
		QuitAction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		m1.add(LoadFromfilesAction);
		m1.add(exportAllAction);
		m1.add(exportSelectionAction);
		m1.addSeparator();
		m1.add(QuitAction);
		
		JMenuItem  nextAliveHostAction = new JMenuItem(" Next alive Host ");
		JMenuItem  nextOpenHostAction = new JMenuItem(" Next Open Host ");
		JMenuItem  nextDeadHostAction = new JMenuItem(" Next Dead Host ");
		JMenuItem  priviousAliveHostAction = new JMenuItem(" privious alive Host ");
		JMenuItem  priviousOpenHostAction = new JMenuItem("privious Open Host ");
		JMenuItem  priviousDeadHostAction = new JMenuItem("privious Dead Host ");
		JMenuItem  FindAction = new JMenuItem(" Find ");
		
		m2.add(nextAliveHostAction);
		m2.add(nextOpenHostAction);
		m2.add(nextDeadHostAction);
		m2.addSeparator();
		m2.add(priviousAliveHostAction);
		m2.add(priviousOpenHostAction);
		m2.add(priviousDeadHostAction);
		m2.addSeparator();
		m2.add(FindAction);
		
		
		JMenuItem  showDetailAction = new JMenuItem("showDetail ");
		JMenuItem  rescanIPAction = new JMenuItem(" rescanIP(s) ");
		JMenuItem  deleteIPAction = new JMenuItem("deleteIP(s) ");
		JMenuItem  copyIPAction = new JMenuItem(" Copy IP ");
		JMenuItem  CopydetailsAction = new JMenuItem("Copydetails");
		JMenuItem  OpenAction = new JMenuItem(" Open ");
		
		m3.add(showDetailAction);
		m3.addSeparator();
		m3.add(rescanIPAction);
		m3.add(deleteIPAction);
		m3.addSeparator();
		m3.add(copyIPAction);
		m3.add(CopydetailsAction);
		m3.addSeparator();
		m3.add(OpenAction);
		
		JMenuItem  AddcurrentAction = new JMenuItem(" Add current ");
		JMenuItem  ManagefavoriteAction = new JMenuItem(" Manage favorite ");
		
		m4.add(AddcurrentAction);
		m4.add(ManagefavoriteAction);
		
		JMenuItem  PreferencesAction = new JMenuItem(" Preferences... ");
		JMenuItem  FetchersAction = new JMenuItem(" Fetchers... ");
		JMenuItem  SelectionAction = new JMenuItem(" Selection ");
		JMenuItem  ScanstatisticsAction = new JMenuItem(" Scan statistics ");
		
		m5.add(PreferencesAction);
		m5.add(FetchersAction);
		m5.addSeparator();
		m5.add(SelectionAction);
		m5.add(ScanstatisticsAction);
		
		
		JMenuItem  gettingstartedAction = new JMenuItem(" Getting Started ");
		JMenuItem  OfficialwebsiteAction = new JMenuItem(" Official website ");
		JMenuItem  FAQAction = new JMenuItem(" FAQ ");
		JMenuItem  ReportanissueAction = new JMenuItem(" Report an issue ");
		JMenuItem  PluginAction = new JMenuItem(" Plug ins ");
		JMenuItem  CommendlineusageAction = new JMenuItem(" Commend-line usage ");
		JMenuItem  checkfornewerversionAction = new JMenuItem(" checkfornewerversion... ");
		JMenuItem  AboutAction = new JMenuItem(" About ");
		
		m6.add(gettingstartedAction);
		m6.addSeparator();
		m6.add(OfficialwebsiteAction);
		m6.add(FAQAction);
		m6.add(ReportanissueAction);
		m6.add(PluginAction);
		m6.addSeparator();
		m6.add(CommendlineusageAction);
		m6.addSeparator();
		m6.add(checkfornewerversionAction);
		m6.addSeparator();
		m6.add(AboutAction);
		
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		mb.add(m5);
		mb.add(m6);
		
		
		cb1 = new JComboBox<String>();
		cb1.addItem("IP Range");
		cb1.addItem("Random");
		cb1.addItem("Text file");
		cb2 = new JComboBox<String>();
		cb2.addItem("/26");
		cb2.addItem("/24");
		cb2.addItem("/16");
		cb2.addItem("255...192");
		cb2.addItem("255...128");
		cb2.addItem("255...0");
		cb2.addItem("255..0.0");
		cb2.addItem("255.0.0.0");
		
		
		p1.add(l1);
		p1.add(tf1);
		p1.add(l2);
		p1.add(tf2);
		
		p1.add(cb1);
		p2.add(l3);
		p2.add(tf3);
		p2.add(ip);
		p2.add(cb2);
		p2.add(st);
		p.add(p1);
		p.add(p2);
		
		JPanel statusP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		statusP.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(statusP, BorderLayout.SOUTH);
		JLabel ready = new JLabel("Ready");
		ready.setPreferredSize(new Dimension(200,16));
		ready.setBorder(new BevelBorder(BevelBorder.RAISED));
		JLabel display = new JLabel("Display:All");
		display.setPreferredSize(new Dimension(200,16));
		display.setBorder(new BevelBorder(BevelBorder.RAISED));
		JLabel thread = new JLabel("Thread:0");
		thread.setPreferredSize(new Dimension(200,16));
		thread.setBorder(new BevelBorder(BevelBorder.RAISED));
		statusP.add(ready);
		statusP.add(display);
		statusP.add(thread);
		JScrollPane scrollPane = new JScrollPane(jt);
		
	
		st.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JButton b = (JButton)e.getSource();
				

				if(b.getText().equals(" start")) {

					b.setText("stop");
					IPtable();
					}
				
				else

					b.setText(" start");
				
				
				}
		});
		String myIp = null;
		String myHostname = null;
		try {
			InetAddress inet = InetAddress.getLocalHost();
			
			 myHostname = inet.getHostName();
			 myIp = inet.getHostAddress();
		}catch(Exception e) {
			e.printStackTrace();
		}
			fixedip = myIp.substring(0, myIp.lastIndexOf(".")+1);
			tf1.setText(fixedip+"0");
			tf2.setText(fixedip+"254");
			tf3.setText(myHostname);
			
		add(p,BorderLayout.NORTH);
		add(scrollPane);
		setJMenuBar(mb);
		setSize(700, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
				
		
	}

	public static void main(String[] args) {
		PingRRT pr = new PingRRT();
	}
	
	void IPtable() {
		
		for (int i = 1; i < 255; i++) {
		int ip = i;
		Thread thread = new Thread() {
			
		public void run() {
		try {
				jdtm.setRowCount(0);
				String ipAddress = "192.168.3."+ip;
				String Ping =null;
				InetAddress inet = InetAddress.getByName(ipAddress);
				long finish = 0;
				long start = new GregorianCalendar().getTimeInMillis();
				Object row[]=new Object[5];
				if (inet.isReachable(200)) {
					finish = new GregorianCalendar().getTimeInMillis();
					
					Runtime run=Runtime.getRuntime();
					Process p=run.exec("ping -a "+ipAddress);
					BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
					String read;
					while((read=br.readLine())!=null) {
						Pattern pattern=Pattern.compile("Ping\\s(.+)\\s32");
						Matcher matcher=pattern.matcher(read);
						if(matcher.find())
							row[2]="[n/a]";
						pattern=Pattern.compile("Ping\\s(.+)\\s\\[");
						matcher=pattern.matcher(read);
						if(matcher.find())
							row[2]=matcher.group(1);
						if(read.indexOf("ms") >= 0) {
							pattern=Pattern.compile("(\\d+ms)(\\s+)(TTL=)(\\d+)");
							Matcher match=pattern.matcher(read);
							if(match.find()) {
								row[1] = match.group(1);
								row[3] = match.group(4);
							}
					}
						
					}
					
					row[0]= "O" +ipAddress; 
					
					ExecutorService es = Executors.newFixedThreadPool(20);
					int timeout = 20;
					List<Future<ScanResult>> futures = new ArrayList<>();
					int openPorts =0;
					String openportnum = "";
					for(int port = 1; port<=1024;port++) {
						try {
							Socket socket = new Socket();
							socket.connect(new InetSocketAddress(ipAddress, port), timeout);
							socket.close();
						if(openportnum=="")
							openportnum+=port;
						else
							openportnum+=","+port;	
						} catch (Exception e) {
							
						}
					}
					es.awaitTermination(20L, TimeUnit.MICROSECONDS);
					row[4] = openportnum;
					
				} else {      
					finish = new GregorianCalendar().getTimeInMillis();
					row[0]="X"+ipAddress;
					row[1]= 0 + "ms";
					row[2]="[n/s]";
					row[3]="[n/a]";
					row[4]="[n/a]";
				}
				
				jdtm.addRow(row);
		} catch (Exception e) {
			e.printStackTrace();
				}
			}
		};
		thread.start();
		}
	}
}