/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package irrgarten;

/**
 *
 * @author adam
 */
public class TestP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Directions dir= Directions.LEFT;
        Orientation orient=Orientation.HORIZONTAL;
        GameCharacter Pers=GameCharacter.MONSTER;
        System.out.println("Prueba direcciones->" + dir);
        System.out.println("Prueba de orientaciones->" + orient);
        System.out.println("Prueba de personajes->" + Pers);
        
        
        Weapon arma=new Weapon(5.5f, 3);
        Weapon arma2=new Weapon(1.0f, 0);
        
        System.out.println("Arma 1-> " + arma.toString() + "ataque->" + arma.attack());
        System.out.println("Arma 1 después de 1 ataque: " + arma.toString()); 
        
        System.out.println("Arma 2-> " + arma2.toString() + "ataque->" + arma2.attack());
        System.out.println("Arma 2 después de 1 ataque: " + arma2.toString());
        
        Shield escud=new Shield(2.5f, 1);
        Shield escud2=new Shield(1.0f, 0);
       
        System.out.println("escudo1-> " + escud.toString() + "ataque->" + escud.protection());
        System.out.println("escudo1 después de 1 ataque: " + escud.toString()); 
        
        System.out.println("escudo  2-> " + escud2.toString() + "escudo2->" + escud2.protection());
        System.out.println("escudo2 después de 1 ataque: " + escud2.toString());
        
        GameState estado=new GameState("Laberinto_e", "Jugadores_e", "Monstruos_e", 
                "Primer Turno", false, 0);
        
        System.out.println("Jugador actual: " + estado.getCurrentPlayer());
        System.out.println("Hay ganador? " + estado.isWinner());
        
        System.out.println("--- PRUEBA INICIAL ---");
        System.out.println("Labyrinth: " + estado.getLabyrinth());
        System.out.println("Players: " + estado.getPlayers());
        System.out.println("Monsters: " + estado.getMonsters());
        System.out.println("Log: " + estado.getLog());
        System.out.println("Jugador actual: " + estado.getCurrentPlayer());
        System.out.println("Hay ganador? " + estado.isWinner());

        System.out.println("\n--- MUTACIÓN DE VALORES ---");

        String newLabyrinth = "Laberinto [Turno 5]";
        String newPlayers = "Jugadores: 2 vivos";
        String newMonsters = "Monstruos: 1 vivo";
        int newCurrentPlayer = 1;
        boolean newWinner = true;
        String newLog = "Adam ha ganado.";

        estado.setLabyrinth(newLabyrinth);
        estado.setPlayers(newPlayers);
        estado.setMonsters(newMonsters);
        estado.setCurrentPlayer(newCurrentPlayer);
        estado.setWinner(newWinner);
        estado.setLog(newLog);

        System.out.println("\n--- PRUEBA DE MUTACIÓN FINAL ---");
        System.out.println("Labyrinth: " + estado.getLabyrinth());
        System.out.println("Players: " + estado.getPlayers());
        System.out.println("Monsters: " + estado.getMonsters());
        System.out.println("Log: " + estado.getLog());
        System.out.println("Jugador actual: " + estado.getCurrentPlayer());
        System.out.println("Hay ganador? " + estado.isWinner());
        
        System.out.println("\n--- 4. Prueba de la Clase Dice (Probabilidades) ---");
        
        Dice Dice=new Dice();
        int totalPruebas = 1000;
        int resucitados = 0;
        int descartados_0 = 0;
        int descartados_MAX = 0;
        
        // Prueba de métodos de probabilidad (resurrectPlayer y discardElement)
        for (int i = 0; i < totalPruebas; i++) {
            // Prueba resurrectPlayer (probabilidad 0.3)
            if (Dice.resurrectPlayer()) {
                resucitados++;
            }
            
            // Prueba discardElement con usesLeft = 0 (debe ser TRUE 100% de las veces)
            if (Dice.discardElement(0)) {
                descartados_0++;
            }

            // Prueba discardElement con usesLeft = MAX_USES (debe ser FALSE 100% de las veces)
            if (Dice.discardElement(5)) {
                descartados_MAX++;
            }
        }
        
        System.out.printf("resurrectPlayer: TRUE %d/%d (Esperado: 30%%)\n", resucitados, totalPruebas);
        System.out.printf("discardElement(0): TRUE %d/%d (Esperado: 100%%)\n", descartados_0, totalPruebas);
        System.out.printf("discardElement(MAX_USES): TRUE %d/%d (Esperado: 0%%)\n", descartados_MAX, totalPruebas);

        // Prueba de métodos de rango (randomPos, weaponsReward, usesLeft)
        System.out.println("\n--- 5. Prueba de Métodos de Rango ---");
        System.out.println("Posición aleatoria (max=5): " + Dice.randomPos(5)); 
        System.out.println("Jugador que comienza (n=4): " + Dice.whoStarts(4)); 
        System.out.println("Armas de recompensa: " + Dice.weaponsReward()); // Rango [0, 2] 
        System.out.println("Usos asignados: " + Dice.usesLeft()); // Rango [0, 5] 
        System.out.printf("Inteligencia aleatoria-> " + Dice.randomIntelligence() + "\n"); 
        
        // Prueba del método discard en las armas
        // NUEVA PRUEBA: Prueba del método discard en las armas y escudos
        System.out.println("\n--- 6. Prueba de Discard en Weapon y Shield ---");

        // Crear instancias para los casos extremos de usos:
        // 0 usos -> Debería ser descartado (TRUE), ya que la probabilidad es 1.0 (inversamente proporcional) 
        Weapon arma_descartable = new Weapon(1.0f, 0); 
        Shield escudo_descartable = new Shield(1.0f, 0);

        // MAX_USES (5) usos -> No debería ser descartado (FALSE), ya que la probabilidad es 0.0 
        Weapon arma_segura = new Weapon(5.0f, 5); 
        Shield escudo_seguro = new Shield(5.0f, 5);

        System.out.println("Arma (0 usos): " + arma_descartable.toString() + " se descarta? " + arma_descartable.discard());
        System.out.println("Escudo (0 usos): " + escudo_descartable.toString() + " se descarta? " + escudo_descartable.discard());

        System.out.println("Arma (MAX usos): " + arma_segura.toString() + " se descarta? " + arma_segura.discard());
        System.out.println("Escudo (MAX usos): " + escudo_seguro.toString() + " se descarta? " + escudo_seguro.discard());

        // Prueba de probabilidad para un caso intermedio (3 usos)
        int descartados_discard_arma = 0;
        int descartados_discard_escudo = 0;
        int totalPruebas_discard = 1000;

        for (int i = 0; i < totalPruebas_discard; i++) {
        // Un elemento con 3 usos. La probabilidad de descarte es (MAX_USES - usesLeft) / MAX_USES.
        // Con MAX_USES = 5 [cite: 114] y usesLeft = 3, la probabilidad es (5-3)/5 = 0.4 (40%)
        Weapon arma_media = new Weapon(1.0f, 3); 
        Shield escudo_medio = new Shield(1.0f, 3);
    
        if (arma_media.discard()) {
        descartados_discard_arma++;
        }
    
        if (escudo_medio.discard()) {
        descartados_discard_escudo++;
        }
    }
        System.out.printf("Arma (3 usos): Descartados %d/%d (Esperado: ~40%%)\n", descartados_discard_arma, totalPruebas_discard);
        System.out.printf("Escudo (3 usos): Descartados %d/%d (Esperado: ~40%%)\n", descartados_discard_escudo, totalPruebas_discard);
    }
    
    
}
