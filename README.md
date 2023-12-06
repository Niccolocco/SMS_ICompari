# SMS_ICompari

--- Tutorial per l'utilizzo di git ---

LEGENDA:
git pull = scarica gli aggiornamenti

git push = carichi gli aggiornamenti sulla repository di GitHub

git status = quando esegui una qualsiasi azione, tipo scrivere nuovo codice oppure cancellare un file, questo comando ti permette di vedere cosa è accaduto sul progetto salvato in locale dall'ultimo pull che è stato eseguito (si consiglia di usarlo spesso per controllare cosa è stato fatto e si può usare per controllare la selezione dei file dopo l'esecuzione del comando "git add")

git add . = serve per selezionare tutti i file che sono colorati rosso (che quindi non verranno inviati nella commit). Se invece si vogliono mandare singoli file senza selezionarli tutti si può scrivere "git add /*nome del file + estensione*/"

git commit -m /*MESSAGGIO DELLA COMMIT*/ = serve per mandare una commit. Questo comando prenderà e manderà tutti i file selezionati dal "git add ." (il messaggio ci deve essere per forza altrimenti da errore e possibilmente il messaggio deve essere significativo)



PROCESSO DA SEGUIRE QUANDO SI LAVORA SUL PROGETTO:

*** PER OGNI COMANDO DA ESEGUIRE BISOGNA APRIRE GIT BASH DALLA CARTELLA IN CUI E' STATO SALVATO IL PROGETTO ***


1. PRIMA di modificare il progetto si deve eseguire "git pull" per recuperare l'ultima versione del progetto modificata da un membro del gruppo

2. Fare quel che si vuole sul progetto senza distruggerlo (possibilmente)

3. Quando si finisce di modificare bisogna eseguire "git status" per controllare i file che sono stati effettivamente modificati

4. Usare il comando "git add ." oppure "git add /*nome del file + estensione*/" per selezionare i file che si vogliono mandare con la commit

4.1. Si può riutilizzare "git status" per controllare che i file siano stati effettivamente selezionati

5. Usare il comando "git commit -m /*MESSAGGIO DELLA COMMIT*/" per prendere i file modificati e creare la commit

6. Usare il comando "git push" per salvare effettivamente i file e aggiornare il progetto su GitHub


IMPORTANTE: non date tutto per scontato, controllate il messaggio che vi esce sul terminale nel caso in cui è stato dato un errore. Perchè la scritte degli errori sono simili ai messaggi di conferma.
