package root;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateurTest {

  @Test
  void validerNombre() {
    String valeur = "123";
    String valeur2 = "123.5";
    String valeur3 = "A";
    String valeur4 = "123A";

    assertTrue(Validateur.validerNombre(valeur));
    assertFalse(Validateur.validerNombre(valeur2));
    assertFalse(Validateur.validerNombre(valeur3));
    assertFalse(Validateur.validerNombre(valeur4));
  }

  @Test
  void validerHeure() {
    String valeur = "12";
    String valeur2 = "123";
    String valeur3 = "A";
    String valeur4 = "123A";

    assertTrue(Validateur.validerHeure(valeur));
    assertFalse(Validateur.validerHeure(valeur2));
    assertFalse(Validateur.validerHeure(valeur3));
    assertFalse(Validateur.validerHeure(valeur4));
  }

  @Test
  void validerImmatriculation() {
    String valeur = "AA-123-AA";
    String valeur2 = "AA123AA";
    String valeur3 = "AA 123 AA";
    String valeur4 = "AA123A";
    String valeur5 = "AA123AAA";

    assertTrue(Validateur.validerImmatriculation(valeur));
    assertTrue(Validateur.validerImmatriculation(valeur2));
    assertTrue(Validateur.validerImmatriculation(valeur3));
    assertFalse(Validateur.validerImmatriculation(valeur4));
    assertFalse(Validateur.validerImmatriculation(valeur5));
  }

  @Test
  void validerMail() {
    String valeur = "test@gmail.com";
    String valeur2 = "test";
    String valeur3 = "test@gmail";
    String valeur4 = "test@gmail.";
    String valeur5 = "@gmail.com";

    assertTrue(Validateur.validerMail(valeur));
    assertFalse(Validateur.validerMail(valeur2));
    assertFalse(Validateur.validerMail(valeur3));
    assertFalse(Validateur.validerMail(valeur4));
    assertFalse(Validateur.validerMail(valeur5));
  }

  @Test
  void validerSiret() {
    String valeur = "12345678901234";
    String valeur2 = "1234567890123";
    String valeur3 = "123456789012345";

    assertTrue(Validateur.validerSiret(valeur));
    assertFalse(Validateur.validerSiret(valeur2));
    assertFalse(Validateur.validerSiret(valeur3));
  }

  @Test
  void validerPseudo() {
    String valeur = "test";
    String valeur2 = "test123";
    String valeur3 = "test_123";
    String valeur4 = "test-123";

    assertTrue(Validateur.validerPseudo(valeur));
    assertTrue(Validateur.validerPseudo(valeur2));
    assertTrue(Validateur.validerPseudo(valeur3));
    assertFalse(Validateur.validerPseudo(valeur4));
  }

  @Test
  void validerNomPropre() {
    String valeur = "test";
    String valeur2 = "test123";
    String valeur3 = "test_123";
    String valeur4 = "test-123";

    assertTrue(Validateur.validerNomPropre(valeur));
    assertFalse(Validateur.validerNomPropre(valeur2));
    assertFalse(Validateur.validerNomPropre(valeur3));
    assertFalse(Validateur.validerNomPropre(valeur4));
  }

  @Test
  void validerNumTel() {
    String valeur = "0123456789";
    String valeur2 = "012345678";
    String valeur3 = "01234567890";

    assertTrue(Validateur.validerNumTel(valeur));
    assertFalse(Validateur.validerNumTel(valeur2));
    assertFalse(Validateur.validerNumTel(valeur3));
  }

  @Test
  void validerCodePostal() {
    String valeur = "12345";
    String valeur2 = "1234";
    String valeur3 = "123456";

    assertTrue(Validateur.validerCodePostal(valeur));
    assertFalse(Validateur.validerCodePostal(valeur2));
    assertFalse(Validateur.validerCodePostal(valeur3));
  }

  @Test
  void validerMdp() {
    String valeur = "Zerte45.";
    String valeur2 = "Zerte45";
    String valeur3 = "Rert45.";
    String valeur4 = "rerte45.";

    assertTrue(Validateur.validerMdp(valeur));
    assertFalse(Validateur.validerMdp(valeur2));
    assertFalse(Validateur.validerMdp(valeur3));
    assertFalse(Validateur.validerMdp(valeur4));
  }

  @Test
  void validerPays() {
    String valeur = "France";
    String valeur2 = "france";
    String valeur3 = "espagne";

    assertTrue(Validateur.validerPays(valeur));
    assertFalse(Validateur.validerPays(valeur2));
    assertFalse(Validateur.validerPays(valeur3));
  }

  @Test
  void validerMention() {
    String valeur = "";
    String valeur2 = "bis";
    String valeur3 = "TER";
    String valeur4 = "test3";
    String valeur5 = "test-3";

    assertTrue(Validateur.validerMention(valeur));
    assertTrue(Validateur.validerMention(valeur2));
    assertTrue(Validateur.validerMention(valeur3));
    assertFalse(Validateur.validerMention(valeur4));
    assertFalse(Validateur.validerMention(valeur5));
  }

  @Test
  void validerTypeVoie() {
    String valeur = "Rue";
    String valeur2 = "Rue";
    String valeur3 = "Avenue";
    String valeur4 = "test2";

    assertTrue(Validateur.validerTypeVoie(valeur));
    assertTrue(Validateur.validerTypeVoie(valeur2));
    assertTrue(Validateur.validerTypeVoie(valeur3));
    assertFalse(Validateur.validerTypeVoie(valeur4));
  }

  @Test
  void validerComplement() {
    String valeur = "Etage 2";
    String valeur2 = "Etage2";
    String valeur3 = "2 test";

    assertTrue(Validateur.validerComplement(valeur));
    assertTrue(Validateur.validerComplement(valeur2));
    assertFalse(Validateur.validerComplement(valeur3));
  }

  @Test
  void validerVille() {
    String valeur = "Paris";
    String valeur2 = "paris";
    String valeur3 = "test2";
    String valeur4 = "l'ile de ré";

    assertTrue(Validateur.validerVille(valeur));
    assertFalse(Validateur.validerVille(valeur2));
    assertFalse(Validateur.validerVille(valeur3));
    assertTrue(Validateur.validerVille(valeur4));
  }
}