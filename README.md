# TT Weather-App 

***


## SCOPE

La vita di tutti noi è sempre più affiancata, supportata e a volte guidata (quasi pilotata), dalle interazioni definite tra sistemi informativi più o meno complessi, IOT, ecc.

In questo contesto, per quanto riguarda l'end-consumer, tra le tematiche che si stanno maggiormente diffondendo in questi anni anche tra i non addetti ai lavori troviamo sicuramente la **domotica** e la **wearable technology** (dispositivi indossabili).
L'ambito di queste tecnologie è uscito dal ristretto perimetro dei Geek con estrema forza, trovando applicazione in ambito civile, industriale, medicale, del wellness, ecc...

Le applicazioni a questi dedicate, si basano su rilevazioni e dati recuperati tramite sensori, API o sottosistemi, su cui definiscono routine ad uso dell'utente.
Un altro punto in comune tra domotica e wearable technology è che entrambe integrano e utilizzano funzioni legate al meteo; ad esempio per programmare attività in base all'orario di alba e tramonto, alla quantità di umidità e precipitazioni, alla temperatura, ecc... o per combinare questi dati con altre rilevazioni (es. temperatura interna/esterna, consumo kcal, ecc.), al fine di ottenere misurazioni più precise.

Focalizzandoci quindi sull'importanza delle applicazioni meteo, in assoluto tra quelle storicamente a maggior diffuse e più ricche di dati globali accessibili (interoperabili e storicizzati) e sempre aggiornati, il gruppo si pone come obiettivo quello di proporre un interfaccia client, estensibile, che parta proprio dalla "componente" **Applicazione Meteo**, come modulo di start-up e rodaggio di una futuribile e più completa interfaccia (ad esempio di domotica, alert/protezione civile o healthcare) che possa fare da hub e display a varie funzionalità informative e di alert.


# Analisi

Nella sua forma base, l'applicazione è sostanzialmente un display di informazioni meteo "live" su una località di interesse.

In modalità premium è possibile "navigarne i contenuti", cambiando la località di interesse o il periodo di riferimento (storico - live - forecast).

In generale l'applicazione dovrà presentare informazioni elaborate/rilevate in tempo reale, rilevate tramite sensori, API o altro, nell'ottica di estendersi a consolle per la domotica.

Partendo dalla "sezione" dedicata al meteo: da qui, oltre alle rilevazioni live e in costante aggiornamento, l'utente può navigare tra dati storicizzati (resi dalle API disponibili o salvati in locale) oppure, se supportato dalle API attivate, avere un'indicazione del forecast dei giorni immediatamente successivi.

Un tasto "HOME" consentirà di tornare alla schermata principale dell'applicazione, preview delle altre sezioni/funzionalità che poteremo integrare successivamente. 
***
**La Nostra Whether APP**, la immaginiamo così
### Interfaccia MeteoApp
![weather](https://github.com/TDianaAle/MeteoApp2/assets/153687631/8eee7690-a822-464e-9a8e-196f0bc129d2)

### Interfaccia Home
_come se integrata in una consolle di domotica_
![home](https://github.com/TDianaAle/MeteoApp2/assets/153687631/2cbfb26f-e535-4be5-9274-017df05c49ff)

La consolle cresce e si estende man mano che integriamo nuove funzioni e applicazioni, partendo da quella del meteo.

***

## Requisiti funzionali di base
*    Selezione della località di interesse
*    Fornisce una indicazione in tempo reale su
     *    meteo (sole, nuvole, ecc.),
     *    temperatura (gradi centigradi),
     *    umidità (%),
     *    vento (meter/sec)
*    Mette in evidenza Alert importanti (estremo freddo o caldo o eventi eccezionali)
*    Ricerca per Località - è sufficiente indicare il nome di una città (es. Roma) per avere a display le informazioni previste
*    Interfaccia dinamica (ridimensionamento, aggiornamento automatico dei contenuti)
*    L’informazione "meteo" è corredata da una immagine coerente con la combinazione dei dati mostrati (es. fiocco di neve, termometro rosso, ecc.)


## Funzionalità opzionali:
*    Ricerca tramite coordinate GPS 
*    Tra le informazioni esito di ricerca riporta ora e coordinate GPS della rilevazione
*    Prevedere almeno 7 “stati” [sereno, nebbia, variabile, nuvoloso, pioggia, neve, rovesci, temporali]
*    Espone funzioni per essere integrata in interfacce più estese e complete
*    All’esito dello “stato del meteo” corrisponde un suono appropriato
*    Consente di monitorare una "location" e memorizzarne i dati (storicizzazione)
*    Dispone di grafiche sulle rilevazioni meteo storicizzare di una o più zone monitorate
*    Multi-language

## Funzionalità premium (sotto licenza):
*    Previsioni meteo (forecast) sulla zona monitorata
*    Consente di accedere allo storico delle rilevazioni eseguite da terza parte sulla zona di interesse
*    Selezione delle unità di misura utilizzate



# Analisi e modello del dominio

Seguendo un approccio AGILE, si partirà dalla realizzazione della Weather-APP e poi della consolle/cruscotto in cui questa è integrata e in/da cui, in progressione, potremo aprire ad altre funzionalità e servizi supportati. L'intera implementazione sarà governata da questo principio di scalabilità, finalizzata all'integrazione continua di nuove funzionalità/app, il più possibile indipendente dalle tecnologie utilizzate in fase di implementazione.

Il seguente schema UML rappresenta gli elementi principali da implementare e gestire
![UML_1_final](https://github.com/TDianaAle/MeteoApp2/assets/153687631/8106a6fd-1b99-4f62-b716-85eabeb8f769)


Come detto, una parte dei dati è raccolta tramite API, mentre altre (per limiti di licenza o altro) saranno alimentate tramite dati locali e statici.
I dati elaborati sono soggetti a (download e) refresh costante e automatico: per evitare errori bloccanti, dobbiamo gestire il caso nel caso si tenti di avviare o utilizzare l'applicazione (anche solo per la demo) senza aver disponibile una connessione ad internet.
Un'altra difficoltà, evidente fin dalla prima lettura delle specifiche delle API disponibili, è rappresentata dal fatto che i dati forniti hanno una struttura annidata e inoltre, anche all'interno dello stesso servizio, in alcuni casi la metrica di rappresentazione è selezionabile da parametro e in altri invece la dovremo convertire runtime.

Come anticipato, ci concentreremo sulla parte attiva dell'applicazione (la Wheather-App), lasciando in priorità più bassa l'implementazione (comunque solo demo rappresentative) delle altre funzionalità del pannello HOME


***

# Design
Trattandosi di una Applicazione (GUI) Desktop o per consolle/device dedicati, abbiamo optato per il pattern architetturale MVC, **Model-View-Controller**, che divide l'applicazione in tre componenti principali:
- il Modello (rappresenta i dati e la logica di business),
- la Vista (visualizza i dati all'utente)
- il Controller (gestisce l'input dell'utente e coordina l'interazione tra Modello e Vista).

Il Modello prompta i dati rilevati da sensori o comunicati dalle API supportate in base alla selezione utente (location o element/raccolta); non applica operazioni particolari, se non conversioni su metriche e timezone. In particolare le interazioni tra l'applicazione e le API chiamate REST che restituiscono file JSON. L'applicazione utilizza un'unica utenza applicativa per ognuna delle API supportate e può usare la stessa utenza per più API, a seconda del servizio selezionato. Come detto, si tratta di una applicazione da consolle per la quale non è prevista la gestione di diversi utenti (tenant) o profili di utilizzo. I dati monitorati sono aggiornati in automatico ogni 30 secondi.


## ARCHITETTURA

**La soluzione prevede** 3 componenti principali
 1. I Servizi esterni da cui ricaviamo dati e informazioni (es. API)
 2. Weather-App, nelle sue componenti di consolle (GUI) e applicative
 3. La Home/Consolle, cruscotto (widget) delle varie App integrate nel dispositivo


L'applicazione comunica con i servizi esterni e al contempo espone metodi per essere integrata in altri Sistemi.

**L'utente interagisce**
- con la WeatherApp
    - selezionando la località di interesse
    - selezionando il giorno di interesse dalla sezione forecast
    - cliccando sul tasto home per andare al pannello principale
- della Home/Consolle
    - per accedere ad una app specifica [click sulla preview]
    - a seconda delle funzionalità messe a disposizione dei singoli widget attivati (es. seleziona la preview, scroll risultati, ecc.)

**Al variare della location** in input e comunque, a seconda timing impostato, la WeatherApp avvia download e una nuova elaborazione delle info meteo per la località selezionata

Il seguente schema UML rappresenta le principali componenti ipotizzate in fase di progettazione, completi delle relative relazioni e dei metodi principali
![UML_2_final](https://github.com/TDianaAle/MeteoApp2/assets/153687631/488e7097-2a1a-4feb-aaef-e5b12af3406b)


## Design dettagliato

L'applicazione ha obiettivo di fornire agli utenti informazioni meteorologiche aggiornate per una determinata città.

La soluzione proposta è un'applicazione Java che utilizza l'API di OpenWeatherMap per recuperare i dati meteorologici corrispondenti al nome della città inserito dall'utente. L'applicazione è strutturata come segue:

1. **Interfaccia Utente** - L'applicazione presenta un'interfaccia grafica (GUI) utilizzando la libreria Swing di Java per consentire agli utenti di inserire il nome della città desiderata.

2. **Connessione HTTP** - Utilizza la classe `HttpURLConnection` per stabilire una connessione HTTP all'API di OpenWeatherMap e inviare una richiesta GET contenente il nome della città e la chiave API.

3. **Gestione delle Risposte API** - L'applicazione gestisce la risposta ricevuta dall'API controllando il codice di risposta HTTP. Se la richiesta ha successo (codice HTTP 200), analizza la risposta JSON per estrarre i dati meteorologici. In caso di fallimento della richiesta, viene visualizzato un messaggio di errore.

4. **Presentazione dei Dati** - I dati meteorologici estratti vengono presentati all'utente tramite l'interfaccia grafica, consentendo loro di visualizzare le informazioni meteorologiche desiderate.

### Funzionalità Chiave
- Recupero dei dati meteorologici per una città specifica.
- Presentazione dei dati all'utente attraverso un'interfaccia grafica intuitiva.
- Gestione degli errori durante il recupero dei dati dall'API.

Questa soluzione fornisce un modo semplice, scalabile e user-friendly per raccogliere e presentare dati (open-data) raccolti da API service online, utilizzando concetti di standard di programmazione Java come le connessioni HTTP e l'analisi JSON.


#### MeteoAPP - INTEGRAZIONE API-SERVICE

Abbiamo **valutato** diversi servizi online e tutti offrono servizi gratuiti e a pagamento; 
dopo una **analisi** di qualche giorno per vedere quante informazioni potevamo ricavare dalle varie versioni free e come queste si presentano (per valutare **l'effort necessario**), abbiamo scelto [https://openweathermap.org/api](https://openweathermap.org/api)

Letta la [documentazione di riferimento](https://openweathermap.org/api/one-call-3), prima di testare effettivamente il servizio, è stato necessario registrarsi e attivare una **"API Key"** da utilizzare poi come parametro di autenticazione nelle successive chiamate applicative.

#### MeteoApp - GET DEI DATI METEO

La classe MeteoApp implementa un'applicazione per ottenere dati meteorologici utilizzando l'API di OpenWeatherMap.

All'inizio pensavano di interpretare qui il tracciato json restituito, ma risultava troppo complesso e confusionario;
inoltre, l'idea è quella di realizzare solo soluzioni scalabili e in questo senso MeteoApp è prototipo di una ipotetica famiglia di classi "connettore" che recuperano dati (open-data) da API online; un connettore per ogni "fonte", come semplice adattamento di questa.

La soluzione segue un modello comune di invio di richieste HTTP a un'API esterna e l'elaborazione della risposta JSON, utilizzando classi standard di Java, sia per gestire la connessione HTTP, sia per l'analisi del JSON.

![MeteoApp1](https://github.com/TDianaAle/MeteoApp2/assets/153687631/48c9e647-fdd8-457c-8df8-8a65e37f5676)

L'output è un oggetto JSONObject, contenente i dati meteorologici che passeremo direttamente a "interfaccia" o ad un modulo "collettore", nel caso in cui per una materia/servizio decidessimo di integrare più fonti.

 
#### MeteoAPP - Gestione esito errore chiamata API
Località non trovata o un problema di rete sono inconvenienti tipici di questo scenario e dobbiamo evitare diventino bloccanti.


Soluzione: gestire l'esito della richiesta HTTP in base al codice di risposta restituito dall'API
![MeteoApp2](https://github.com/TDianaAle/MeteoApp2/assets/153687631/33f4c4a8-4bca-45a3-9b02-f2325112ebc1)

Come evidente anche da questo UML **MeteoApp** è controllata da **Interfaccia**; lì è calata la costruzione della request e l'interpretazione del JSON; questi 2 aspetti e in particolare la gestione delle metriche e dei valori "timing" hanno richiesto particolari attenzioni ed accorgimenti


#### Interfaccia (1) - GUI e Rappresentazione dati
_Funge da modulo di avvio dell’applicazione. Implementata con framework Swing e plugin windows builder._

A questo punto, risolto il problema di selezionare e integrare le chiamate applicative, si è trattato di interpretare correttamente il file JSON restituito. Questo file, che abbiamo poi scoperto avere sezioni con componenti annidati ed eventualmente ripetuti (da gestire come lista albero e array), fornisce molte informazioni dettagliate sulle condizioni meteorologiche per la località passata a parametro. Include coordinate geografiche, condizioni meteorologiche attuali, temperatura, pressione atmosferica, umidità, visibilità, velocità del vento, ecc... 
Metriche e unità di misura devono essere però adattate al contesto: i valori sono forniti a volte in `LONG` e a volte in `DOUBLE`; va considerata la timezone; alcune rappresentazioni sono impostate e rispondono a specifici parametri, mentre altre possono essere applicate (cast) solo a runtime.
Inoltre si è utilizzato il plug-in di Eclipse windows builder per poter utilizzare la GUI di design e lavorare direttamente sull’interfaccia utente.

**INTERFACCIA INTERPRETE JSON**
![interfaccia1](https://github.com/TDianaAle/MeteoApp2/assets/153687631/9b4a3f61-65f0-41ec-979e-b5cca5687979)

_da notare che **WeatherData** è qui rappresentata in modo sintetico, ma è al contempo utilizzata per la gestione delle componenti annidate nel JSON_

In sostanza MeteoApp scarica il tracciato JSON dal servizio online, mentre Interfaccia si occupa di interpretarlo, usarlo per valorizzare tutte le variabili utilizzate e compilare le label rese dall'applicazione

Design Pattern Applicati:
MVC, dove MeteoApp funge da controller, Interfaccia come vista, e il servizio meteorologico come modello.

Al fine di migliorare la modularità, l'estendibilità e la manutenibilità del codice
 (Non implementato ma può essere considerato, se andassimo effettivamente ad integrare più servizi/API sempre relativi al meteo), il pattern Dependency Injection permetterebbe la selezione di una implementazione specifica (OpenWeatherMapService) durante l'esecuzione.
Inoltre, nel caso in cui il WeatherService dovesse avere diverse implementazioni, si potrebbe utilizzare il Factory Method Pattern per delegare la creazione delle istanze a classi specializzate [Model-View-Controller (MVC)]


#### Interfaccia (2) - HOME DOMOTICA
Scopo di questa sezione è mostrare come la MeteoApp può essere integrata all'interno di client, applicazioni e dispositivi differenti;
in questo caso immaginiamo una consolle per la domotica di cui la MeteoApp è una delle applicazioni utilizzate.

Interfaccia 2 si presenta come una collezione di widget e tasti funzione (rapida)
Anche in questo caso abbiamo utilizzato il plugin windows builder di eclipse, ma per poter arrivare al risultato atteso con la flessibilità necessaria, abbiamo dovuto lavorare con un layout nullo/vuoto, andando a disegnare e posizionare da zero ogni elemento (cosa che per altro è evidente nella complessità e ridondanza del codice - situazione da bonificare eventualmente in una fase successiva)

Anche in questo caso si tratta di una implementazione standard di componenti JAVA

![interfaccia2](https://github.com/TDianaAle/MeteoApp2/assets/153687631/299ee5eb-49e2-4789-818b-33655121497f)


Cliccando sulla preview della MeteoApp si carica la schermata corrispondente (ricordiamo che in questo caso caso d'uso, immaginiamo in dispositivo dedicato).
Gli altri widget e i bottoni al momento sono solo immagini statiche, dimostrative.





## Design pattern applicati
Singleton - per l'utilizzo di costanti condivise tra tutte le istanze della classe

Factory Method [SwingUtilities.invokeLater] - utilizza una lambda expression per creare un'istanza di _Interfaccia_

Template Method [getWeatherData(String cityName)] - fornisce uno scheletro di algoritmo (richiesta HTTP, parsing JSON) che può essere personalizzato dalle sottoclassi per implementare dettagli specifici

Exception Handling - L'uso di try-catch per gestire eccezioni


---



# Sviluppo

## Testing automatizzato
Per quanto riguarda questo progetto abbiamo utilizzato il framework JUNIT;
in particolare abbiamo deciso di avere 3 test separati, dedicati alle librerie/funzionalità principali, che interagiscono direttamente con il package di sviluppo disponibile a runtime.
Utile l'integrazione di JUNT con l'IDE eclipse.


### InterfacciaTest.java

Verifica che il metodo updateUI dell'oggetto Interfaccia aggiorni correttamente l'interfaccia utente al refresh dei dati. I dati di prova sono fissati da codice, così da poter verificare un esito atteso coerente.
È l'unico test che usa l'annotazione (decoratore) @Before come metodo di "setup" prima dell'esecuzione del @Test vero e proprio.
Assertion e la consolle dell'IDE confermano l'esito del test.

### MeteoAppTest.java

Esegue il Test della classe MeteoApp e in particolare che il metodo getWeatherData funzioni correttamente, verificando la ricezione di un file JSON (non nullo) da parte dell'applicazione.



### InterfaceImageTest.java

Siccome "scolpire" l'interfaccia grafica ci ha dato qualche grattacapo, questo test è stato funzionale ad assicurarci che nelle modifiche non ci perdessimo nulla di essenziale. Centrato sulle risorse grafiche, che cambiano runtime in base ai dati meteo visualizzati, ci assicura che ogni risorsa utilizzata sarà disponibile e correttamente caricata dall'applicazione.




## Note di sviluppo

### Parti della Libreria Standard JDK per il set-up della GUI
in questo caso `JFrame`, `JPanel`, `JLabel`, `ImageIcon`

**Dove**: `Interfaccia` e in particolare in `InterfacciaDue`

**Permalink**: https://github.com/TDianaAle/MeteoApp2/blob/a0daf94411b9ebdba1e6eb8f24f5843d9ad73f39/app/src/main/java/com/meteoapp2/InterfacciaDue.java

**Snippet**
```
	public InterfacciaDue() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfacciaDue.class.getResource("/assets/mhome.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(616, 432);
		setTitle("Domoteo");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new LineBorder(new Color(239, 239, 239), 5, true));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel telecamere = new JLabel("");
		telecamere.setIcon(
...
		 JLabel weatherDataLabel = new JLabel();
		 weatherDataLabel.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/background.jpg")));
	     //   weatherDataLabel.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/backsunny.jpg")));
	        weatherDataLabel.setToolTipText("");
	        weatherDataLabel.setBounds(26, 32, 134, 230);
	        weatherDataLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        weatherDataLabel.setBorder(new LineBorder(new Color(239, 239, 239), 5, true));
	        weatherDataLabel.setBackground(new Color(255, 255, 255, 100));
	        weatherDataLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
	  
	        weatherDataLabel.setAlignmentY(Component.TOP_ALIGNMENT);
	        contentPane.add(weatherDataLabel);
	             weatherDataLabel.setLayout(null);
	        

	             
	             // Inizializzazione delle variabili
	             temperatureText = new JLabel();
	             temperatureText.setForeground(new Color(255, 255, 255));
	            
	             temperatureText.setVerticalTextPosition(SwingConstants.BOTTOM);
	             temperatureText.setText("17 °C");
```



### Parti della Libreria Standard JDK per l'integrazione delle API e la corretta "GET" del JSON
in questo caso `BufferedReader`, `InputStreamReader`, `HttpURLConnection`, `URL`, `URLEncoder`, `JOptionPane`, `JSONObject`, e `JSONParser`

**Dove**: `MeteoApp`

**Permalink**: https://github.com/TDianaAle/MeteoApp2/blob/a0daf94411b9ebdba1e6eb8f24f5843d9ad73f39/app/src/main/java/com/meteoapp2/MeteoApp.java

**Snippet**:
```
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                JSONParser parser = new JSONParser();
                JSONObject jsonObject = (JSONObject) parser.parse(reader);
                reader.close();
                return jsonObject;
            } else {
                System.err.println("HTTP request failed with response code: " + responseCode);
                JOptionPane.showMessageDialog(null, "Errore nella richiesta API", "Errore", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nella richiesta API", "Errore", JOptionPane.ERROR_MESSAGE);
            return null;
        }
```

### updateUI - per aggiornare l'interfaccia utente con i dati ottenuti dall'API

Estrae i dati da un oggetto JSON e li aggiorna nei componenti appropriati  (`JPanel`) dell'interfaccia utente `Swing` per la visualizzazione dei dati;
Gestisce i dati annidati e il fatto che lo stesso dato potrebbe essere rappresentato in `LONG` o `DOUBLE`

**Dove**: `Interfaccia`

**Permalink**: https://github.com/TDianaAle/MeteoApp2/blob/a0daf94411b9ebdba1e6eb8f24f5843d9ad73f39/app/src/main/java/com/meteoapp2/Interfaccia.java



**JSON input di Esempio**:
```{
  "coord": {
    "lon": 12.2432,
    "lat": 44.1391
  },
  "weather": [
    {
      "id": 500,
      "main": "Rain",
      "description": "light rain",
      "icon": "10n"
    }
  ],
  "base": "stations",
  "main": {
    "temp": 11.23,
    "feels_like": 10.89,
    "temp_min": 10.62,
    "temp_max": 12.46,
    "pressure": 1006,
    "humidity": 95
  },
  "visibility": 10000,
  "wind": {
    "speed": 2.25,
    "deg": 6,
    "gust": 5.45
  },
  "rain": {
    "1h": 0.8
  },
  "clouds": {
    "all": 100
  },
  "dt": 1709240622,
  "sys": {
    "type": 2,
    "id": 2003677,
    "country": "IT",
    "sunrise": 1709185775,
    "sunset": 1709225867
  },
  "timezone": 3600,
  "id": 3178957,
  "name": "Cesena",
  "cod": 200
}
```

**Snippet**:
```
public void updateUI(JSONObject weatherData) {

	JSONObject main = (JSONObject) weatherData.get("main");
 
	JSONObject wind = (JSONObject) weatherData.get("wind");

	JSONObject sys = (JSONObject) weatherData.get("sys");
	
	JSONArray weatherArray = (JSONArray) weatherData.get("weather"); // Ottieni l'array "weather"
	 if (main != null && wind != null && sys != null && weatherArray != null && weatherArray.size() > 0) {
	        // Estrarre i dati dall'array "weather"
	        JSONObject weather = (JSONObject) weatherArray.get(0); // Prendi il primo elemento dell'array
	        
    	double temp = 0.0;
    	try {
    		temp = (double)main.get("temp");
    	}
    		catch (Exception e) {
    			Long longTemp = (long) main.get("temp");
    			temp= longTemp.doubleValue();
    		}
```




# Commenti finali

## Autovalutazione e lavori futuri
> entrambi studenti lavoratori che non hanno frequentato le lezioni in aula

> soddisfatti del risultato finale soprattutto in termini di scalabilità della soluzione


### Diana
Ho dedicato al progetto tutte le sere dopo il lavoro, per circa 1 mese e mezzo.
Come esperienza pregressa ho partecipato, grazie all'opportunità di un tirocinio, alla creazione di una semplice Guestbook in linguaggio Java, utilizzando principalmente la piattaforma di sviluppo Liferay DXP e Gradle per la gestione delle dipendenze. Ho deciso di utilizzare lo stesso ambiente di sviluppo utilizzato per il tirocinio, cioè Eclipse.

Grazie all'integrazione nativa di Git in Eclipse, siamo stati in grado di gestire efficacemente le modifiche apportate al codice. Tuttavia, l'impedimento nella migrazione del progetto da Eclipse a Visual Studio Code, a causa delle differenze tra gli ambienti di sviluppo, ci ha costretto a coordinare il lavoro da remoto per le modifiche al codice e la generazione di report. Questa esperienza mi ha portato a riflettere sull'inefficienza che può derivare dal lavorare in modo isolato sul codice, specialmente quando si incontra difficoltà nel trovare soluzioni. Il confronto e la collaborazione con il mio collega Fabio si sono rivelati cruciali per prendere decisioni ponderate e avanzare con maggiore velocità nel progetto nel suo complesso.

Mi sono occupata della struttura del package in generale, della ricerca delle librerie utili e del plug-in Windows Builder con il quale ho realizzato il design della GUI, il tutto completato da Fabio che in seguito è intervenuto sulle mie parti, dove serviva un confronto oppure in caso di problemi di UX o disallineamento rispetto alla fase di progettazione.

Sono abbastanza soddisfatta del risultato finale.



### Fabio
Primissima esperienza nel fare un'applicazione java da zero.
Abbiamo incontrato difficoltà nell'utilizzare ambienti di sviluppo diversi (che non siamo riusciti ad integrare).
Abbiamo dovuto abbandonare alcune delle proposte avanzate in fase di design perché non riuscivamo ad implementarle in swing e avremmo dovuto stravolgere l'impianto (non impossibile, ma avremmo dovuto impiegare più tempo e abbiamo valutato che forse non ne valeva la pena).
Tempo di lavoro dedicato al progetto: circa un mese full-time o poco più.
Mi sono dedicato soprattutto alle fasi di analisi e design, alla predisposizione delle risorse e alla relazione; riguardo al coding mi sono occupato dell'integrazione standard al servizio API e di alcune problematiche specifiche (formattazione o altro), in modo che Diana potesse andare avanti più spedita nella strutturazione dei codice nel suo complesso e a farlo funzionare.
La soluzione esegue le azioni previste nel contesto specifico (device dedicato alla domotica o simile); vediamo però anche ampie possibilità di miglioramento, che però oggi non siamo ancora in grado di implementare in autonomia.





# Guida Utente


## Per l'utente



## Per il dev





***
## REF

### API
Ref: https://openweathermap.org/api


### Strumenti
https://www.eclipse.org/ide/

https://github.com/

https://balsamiq.com/wireframes/

https://code.visualstudio.com/

https://gradle.org/

https://plantuml.com/


