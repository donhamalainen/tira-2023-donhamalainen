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

'
Kävin ensimmäisessä tehtävässä läpi insertion sort algorytmiä. Algorytmin rakentaminen ei ollut omasta puolestani haastavaa eikä edellyttänyt paljoakaan aikaa sen kokonaisuuden ymmärtämiseen. Haastavin asia oli sisäistää tai ymmärtää koko projektin toiminnallisuus. 

- Insetion Sort algorytmi on yleensä O(n^2) eli neliöllinen (quadratic), mutta voi myös olla lineaarinen O(n) riippuen JSON tai datan esitysjärjestyksestä.
- Reverse - algorytmi eli tässä tapauksessa metodi joka kääntää taulukon ympäri on aikakompleksisuutena O(n) eli lineaarinen.

Raportin kysmyksessä oli "Jos taulukko on jo valmiiksi järjestyksessä nousevaan järjestykseen, ja se aiotaan lajitella laskevaan järjestykseen, kannattaako taulukko lajitella vai kääntää sen järjestys? Miksi, perustele?"

Tässä tapauksessa Reverse metodi on suositeltavampaa koska sen aikakompleksisuus on lineaari O(n) kun taas insertion sort on O(n) tai O(n^2) riippuen taulukon koosta.
'

## 02-TASK

## 03-TASK

## 04-TASK

## 05-TASK

## 06-TASK

## 07-TASK

## 08-TASK

## 09-TASK