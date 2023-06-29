# Pre-Appello del 08/06/2023

**Sistema Gestione palestra**

Sulla base del sistema di gestione di una palestra\* modellato nei task precedenti, si considerino i diagrammi forniti nel *link GitHub* del proprio turno di riferimento (vedi sezione Pre Appello – Creazione Repository per i Gruppi Turno 1 / 2).

L’estensione del progetto prevede l’introduzione delle seguenti **funzionalità**:

**1.** L’Amministratore del sistema può visualizzare lo *storico delle prenotazioni*, produrre grafici ed esportare dati, sulla base di dati quali l'intervallo temporale, il tipo di abbonamento e/o carnet ingressi, la tipologia dei clienti.

**2.** Viene introdotta la categoria del *Cliente VIP*. Un cliente VIP è un cliente che paga una quota
significativamente più alta per l'iscrizione alla palestra oppure un cliente fedele da almeno 10 anni. Un cliente VIP gode degli stessi privilegi del cliente fedele; inoltre ha un trainer personale che gli offre consigli e segue le sue attività senza pagare alcun sovraprezzo. I clienti VIP non vengono più considerati Clienti se non usufruiscono dei servizi della palestra per 10 anni consecutivi.

**3.** Vengono introdotti gli *abbonamenti in promozione* e gli *abbonamenti a fascia ridotta*\*\*. La
palestra mette a disposizione varie promozioni relative al rinnovo dell'abbonamento: rinnovi con acquisto trimestrale o semestrale non prevedono promozioni, quelli di durata annuale hanno uno sconto del 5%, mentre quelli di durata biennale del 10%; un nuovo abbonamento acquistato nei mesi estivi, da giugno ad agosto, di qualunque durata, comporta uno sconto del 20%. Inoltre, esistono delle promozioni per fascia oraria, con limite di utilizzo alle h.17.00; in tal caso lo sconto è del 30%, a prescindere dalla durata del rinnovo o acquisto.

**4.** Periodicamente vengono organizzati *eventi speciali* per clienti fedeli e clienti VIP, come sessioni con trainer famosi o incontri con esperti di fitness o di nutrizione. I clienti fedeli ed i clienti VIP ricevono una notifica ogni volta viene creato un evento di questo tipo ed hanno la possibilità di iscriversi ad esso. In tal caso, a differenza dei clienti fedeli che devono pagare un prezzo prestabilito, i VIP possono parteciparvi gratuitamente. I clienti iscritti ad un evento ricevono un messaggio di promemoria ventiquattr’ore prima.

**5.** Per fidelizzare i clienti ed attrarne di nuovi, è stato deciso di lanciare un’attività di *merchandising*, con prodotti quali integratori, sport drink, spillette, magliette, felpe, zaini e pochette, recanti il logo della palestra. Tali prodotti sono messi in vendita online e chiunque li può acquistare; i clienti fedeli godono di uno sconto fisso del 30% su tutti i prodotti, mentre i VIP del 45%.

\*\*Tali denominazioni non sono significative per lo storico delle prenotazioni.

**CONSEGNA**:

Sulla base delle nuove funzionalità cosa dovete fare:
• aggiornare il diagramma dei casi d'uso;
• ogni studente deve descrivere in formato dettagliato un caso d'uso a scelta fra quelli nuovi o modificarne uno già esistente in base alle nuove funzionalità;
• nel caso lo si ritenga opportuno, aggiornare il modello di dominio;
• ogni studente deve modellare il caso d'uso scelto tra quelli aggiunti in termini di diagramma di sequenza di sistema;
• ogni studente deve identificare un’operazione di sistema relativa all’estensione e descriverla in termini di contratto;
• ogni studente deve produrre un diagramma di sequenza relativo all'operazione di sistema scelta;
• produrre il diagramma delle classi di progetto relativo alle classi e operazioni trattate;
• produrre un documento di relazione PDF che raccolga tutti gli artefatti prodotti (diagrammi, casi d’uso in formato dettagliato, contratti, pattern applicati ed eventuali altre scelte), specificando i singoli autori delle varie parti, incluso l'intero gruppo.
Qualora i contratti non fossero in numero sufficiente, è possibile selezionare nuovi contratti dai diagrammi di sequenza di sistema modellati in precedenza o da casi d'uso non modellati;
analogamente, per i diagrammi di sequenza.

**TERMINI DI CONSEGNA**:

10/06/2023 ore 12.00, da effettuare sul repository di gruppo.
Inviare il documento di relazione PDF anche via email al docente di Laboratorio del proprio turno
(marco.mobilio@unimib.it oppure gabriella.nifosi@unimib.it).

**SUPPORTO VIA FORUM:**

Per chiarimenti sul testo e la consegna potete usare il forum del proprio turno di riferimento dalle ore 12.00 alle ore 18.00 dell’08/06/2023; non è previsto supporto su analisi e progettazione.

\*Per comodità si riportano di seguito le specifiche del sistema.

Si consideri un sistema di gestione dei servizi offerti da una palestra e dei suoi clienti. Chiunque può consultare i servizi relativi alle attività e le offerte proposte dalla palestra, iscriversi alla palestra oppure acquistare un pacchetto di ingressi. Le persone iscritte alla palestra diventano clienti. I clienti sono di due categorie: base e fedeli. Tutti i tipi di clienti ricevono all’iscrizione una tessera, tramite cui vengono identificati all'accesso, e devono pagare un'iscrizione in base al tipo di abbonamento. Un cliente base diventa fedele se almeno una delle seguenti condizioni è verificata: (1) è iscritto alla palestra da almeno 3 anni, quindi ha pagato l'iscrizione alla palestra per almeno tre anni consecutivi, ed ogni anno ha seguito almeno 2 corsi offerti dalla palestra, oppure (2) è iscritto alla palestra da almeno 5 anni ed è entrato nella palestra per attività varie per almeno 250 volte. Un cliente che non usufruisce per più di 2 anni delle attività offerte dalla palestra non viene più considerato come tale.

I servizi offerti dalla palestra sono divisi in due categorie: standard e personalizzati. I servizi standard riguardano attività sportive di gruppo o corsi, quali spinning, aerobica, pilates, acquagym, danza, oppure individuali, quali nuoto, pesistica, attività a corpo libero o con uso di attrezzi. I servizi personalizzati sono riservati ai clienti e possono consistere in una scheda di allenamento personalizzata fornita da un trainer o in una scheda e la supervisione di un trainer di fiducia; in quest’ultimo caso il cliente è tenuto a pagare un sovraprezzo. Invece le persone che hanno acquistato un pacchetto di ingressi, ma non sono iscritte alla palestra, possono seguire soltanto attività standard.

I corsi implicano la presenza di un trainer. Si noti che un trainer può seguire più attività. Ogni corso ha un orario ben definito in cui si specifica il giorno e l'ora di svolgimento e per parteciparvi occorre prenotarsi. Le prenotazioni vengono aperte ventiquattro ore prima dell’inizio del corso; è possibile disdirle o prenotarsi fino al massimo mezz'ora prima dell'inizio del corso.
Il sistema deve poter offrire l'orario complessivo della palestra per un giorno, una settimana oppure un mese. Inoltre, deve poter fornire l'orario relativo ad ogni trainer della palestra.
Fisicamente la palestra è divisa in varie aree. In base alla tipologia dei clienti essi hanno accesso nelle aree a loro riservate. Per esempio, la palestra ha 2 piscine. Una delle due piscine è accessibile a tutte le persone, mentre la seconda soltanto ai clienti fedeli.
Il calcolo del prezzo della palestra varia in base al tipo di abbonamento: mensile, trimestrale, semestrale, annuale. I pacchetti di ingressi hanno dei prezzi di fascia più alta e prevedono cinque o dieci ingressi, usufruibili nell’arco di due mesi.
