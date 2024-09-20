package atividade01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Filme_Test {

    @Test
    public void testCompareTo() {
        Filme_IF f1 = new Filme("A", 5, 2020);
        Filme_IF f2 = new Filme("B", 4, 2021);
        Filme_IF f3 = new Filme("C", 5, 2019);
        Filme_IF f4 = new Filme("D", 5, 2020);
        Filme_IF f5 = new Filme("A", 5, 2020);
        assertTrue(f1.compareTo(f2) < 0); 
        assertTrue(f2.compareTo(f1) > 0);
        assertTrue(f1.compareTo(f3) > 0); 
        assertTrue(f3.compareTo(f1) < 0);
        assertTrue(f1.compareTo(f4) < 0); 
        assertTrue(f4.compareTo(f1) > 0); 
        assertEquals(0, f1.compareTo(f5)); 
    }

    
    
    
    @Test
    public void testToString() {
        Filme_IF f = new Filme("Inception", 5, 2010);
        assertEquals("Inception (2010) [5]", f.toString());
    }

    @Test
    public void testSettersAndGetters() {
        Filme_IF f = new Filme("Original", 3, 2018);
        f.setNome("Novo Nome");
        f.setNota(4);
        f.setAno(2020);

        assertEquals("Novo Nome", f.getNome());
        assertEquals(4, f.getNota());
        assertEquals(2020, f.getAno());
    }
}


