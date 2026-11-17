public class Heuristica {

   public static int evaluar(String estadoActual, String estadoMeta) {
        int fichasMalColocadas = 0;
        int penalizacionFilaDelMedio = 0;
        
        for (int i = 0; i < estadoActual.length(); i++) {
            // Si la ficha no coincide con la meta
            if (estadoActual.charAt(i) != estadoMeta.charAt(i)) {
                fichasMalColocadas++;
                
                // Criterio de dominio: Evaluar la línea horizontal del medio (índices 3, 4 y 5)
                if (i >= 3 && i <= 5) {
                    penalizacionFilaDelMedio += 2; // Castigo extra para obligar a resolver el centro primero
                }
            }
        }
        
        // El costo heurístico total combina fichas mal ubicadas + regla del centro
        return fichasMalColocadas + penalizacionFilaDelMedio;
    }
}

