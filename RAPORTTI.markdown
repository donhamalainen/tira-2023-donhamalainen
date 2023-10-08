# Raportit tehtävistä

Kirjaa tähän tiedostoon **jokaiseen** tehtävään liittyvät omat raporttisi ja analyysisi. Muista että raportti on myös kurssilla **arvosteltava tehtävä**.

Voit sisällyttää raporttiin tekstimuotoisia taulukoita (tasaukset välilyönnein):

```
n     Fill     Search   Total
500   7        700      707
1000  9        288      297
```

Ja näihin liittyviä kuvatiedostoja:

![Esimerkkikuva](report-sample-image.png)

Nämä näkyvät sitten VS Coden Preview -näkymässä (tai oman repositorysi webbisivulla) oikein muotoiltuna. Käytä tässä dokumentissa olevia muotoiluja esimerkkinä kun kirjoitat raporttiasi. 

Huomaa että jos laitat kuvatiedostot vaikka omaan alihakemistoonsa, Markdown -muotoilussa on oltava suhteellinen polku tiedostoon, esimerkiksi `images/report-sample-image.png`. **Älä** käytä absoluuttisia polkuja `C:\Users\tippaleipa\kurssit\TIRA\kuva.png`, koska nämä eivät tietenkään toimi opettajan koneella. Ei kannata laittaa linkkiä etärepoosikaan, vaan nimenomaan paikalliseen tiedostoon.

Voit myös sisällyttää *lyhyitä* koodinpätkiä vaikkapa Java -formaatilla:

```Java
	@Override
	public int hashCode() {
		// Oma nerokas hajautufunktioni!
	}
```
Tarvittaessa käytä myös paremmin muotoiltuja taulukoita:

| n	| Fill	| Search	| Total |
|-----|--------|--------|-------|
| 500	 | 7	| 700	| 707 |
| 1000 |	9	| 288	| 297 | 

Alaluvut jokaisen tehtävän raportille löydät alta.


## 01-TASK

Kävin ensimmäisessä tehtävässä läpi insertion sort algorytmiä. Algorytmin rakentaminen ei ollut omasta puolestani haastavaa eikä edellyttänyt paljoakaan aikaa sen kokonaisuuden ymmärtämiseen. Haastavin asia oli sisäistää tai ymmärtää koko projektin toiminnallisuus. 

- Insetion Sort algorytmi on yleensä O(n^2) eli neliöllinen (quadratic / kvadraattinen), mutta voi myös olla lineaarinen O(n) riippuen JSON tai datan esitysjärjestyksestä.
- Reverse - algorytmi eli tässä tapauksessa metodi joka kääntää taulukon ympäri on aikakompleksisuutena O(n) eli lineaarinen.

Raportin kysmyksessä oli "Jos taulukko on jo valmiiksi järjestyksessä nousevaan järjestykseen, ja se aiotaan lajitella laskevaan järjestykseen, kannattaako taulukko lajitella vai kääntää sen järjestys? Miksi, perustele?"

Tässä tapauksessa Reverse metodi on suositeltavampaa koska sen aikakompleksisuus on lineaari O(n) kun taas insertion sort on O(n) tai O(n^2) riippuen taulukon koosta.

## 02-TASK

### Graaffi analyysi
Tehtävässä 2, askeleessa 3 tehdyssä tehtävässä sain tarkasteltavaksi arvoja, jotka ovat riippuvaisia algorytmistä insertionSort ja myös oman koneeni suoritustehosta. X-akselilla on datan kasvu (n). Huomamme että "Fill" tekee jonkinlaisen pudotuksen alussa, mutta on muutoin lineaarinen kun "Search" on taas lähes eksonentiaalinen. Kuvaajassa nähdään "Fill" ja "Search" risteyskohta, sekä pieniä "droppeja" graafissa. Uskon että nämä "dropit" graaffissa johtuvat tietorakenteen järjestyksestä jolloin hakuun voi mennä vähemmän aikaa. Risteyskohdasta en ole täysin varma.

![Fill & Search Chart](/student_images/task2_step3_chartImage_DonH.png)

![Data](/student_images/task2_step3_dataImage_DonH.png)


### Tehtävä raportti
Lineaarista hakualgorytmiä kutsutaan lineaariseksi, koska se käy tietorakenteen (esim. taulukon tai listan) läpi elementti kerrallaan alusta loppuun asti tai kunnes etsittävä kohde on löydetty. Lineaarisen haun aikakompleksisuusluokka big-O -notaatiolla esiteltynä on O(n), missä n on tietorakenteen pituus (elementtien lukumäärä). Tämä tarkoittaa että algorytmin suoritusaika kasvaa suoraan verrannollisesti tietorakenteen pituuteen (n). Luomamme insertionSort algorytmi ei ole lineaarinen vaan kvadraattinen O(n^2) riippuen tietorakenteen järjestyksestä ja pituudesta. SimpleContaineriin tehdyt muutokset kuten E get() jossa on yksinkertainen for-silmukka on lineaarinen.


## 03-TASK

Kirjaa raporttiisi RAPORTTI.markdown mitä opit tehtävän tekemisestä, mikä oli vaikeaa, mikä helppoa, jne.
Kirjoita myös raporttiisi edellisen analyysikohdan listaamat asiat. Perustele johtopäätöksesi ja ole tarkka analyyseissäsi.
Viittaa suoritusaikataulukoihin ja laatimiisi käyriin (jotka ovat mukana raportissasi), sekä koodin aikakompleksisuusanalyyseihisi.
miksi toteutettuja hakualgoritmeja kutsutaan lineaarisiksi?
Mikä niiden aikakompleksisuusluokka on big-O -notaatiolla esiteltynä?

### Graaffi analyysi
Tehtävässä 3. kirjoitin binäärisen hakualgorytmin, jonka periaate on puolittaa aina haku. Periaate toimii kolmen pisteen avulla, jotka ovat alin (low), keski/avain (mid/key), ja ylä (high). Näiden pisteiden avulla algorytmi tietää (tutkittavan) alueen. Binäärinen hakualgorytmi on O(log n), joka on huomattavasti nopeampi kuin lineaarinen algorytmi O(n). Sanotaan näin että siinä missä lineaarinen saattaa/joutuu käymään läpi koko tietorakenteen. Binäärisessä taas haun puolitusperiaatteen ansiosta käytännössä algorytmi tietää vain kolme tietorakenteen alkiopistettä. Alhaalla olevassa kuvaajassa sininen viiva (Series1) kuvastaa kohtaa Fill ja oranssi (Series2) kohtaa Search.

![Fill & Search Chart](/student_images/task3_chartImage_DonH.png)

### Tehtävä raportti
Tehtävä oli haasteellinen binäärihaun (binary search) osalta. Sain tehtyä iteratiivisen binäärihaun onnistuneesti ja helposti, mutta rekurssiivinen tuotti ongelmia eikä ainakaan vielä (2.10.2023) ole vielä valmis. Ajattelin kuitenkin toteuttaa sen jossain vaiheessa. Huomasin ongelmana pino ylivuodon (stack overflow) tuottaman ongelman enkä ole vielä onnistunut korjaamaan sitä.

Tehtävässä kuitenkin toteuttamani algorytmi toimii siten että se ottaa alimman ja ylimmän pisteen, jossa alinpiste on vakiona 0 ja ylin on tietorakenteen pituus - 1. Keskipiste on taas näiden kahden pisteen erotus kaavalla (alin + (ylin - alin) / 2), eikä kaavalla ((ylin - alin) / 2). Ei näin siksi että tämä mahdollistaa pino ylivuodon (stack overflow). Jos algorytmi ei löydä haluttua numeroa niin se palauttaa -1, joka lopettaa tehtävän.

## 04-TASK

## 05-TASK

## 06-TASK

## 07-TASK

## 08-TASK

## 09-TASK