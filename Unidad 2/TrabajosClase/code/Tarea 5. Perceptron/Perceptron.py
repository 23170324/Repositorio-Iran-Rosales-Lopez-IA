import numpy as np

class Perceptron:
    def __init__(self, N, alpha=0.1):
        # Inicializa la matriz de pesos (N entradas + 1 para el sesgo) y la tasa de aprendizaje
        self.W = np.random.randn(N + 1) / np.sqrt(N)
        self.alpha = alpha

    def escalon(self, x):
        # Aplica la función de activación escalón
        return 1 if x > 0 else 0

    def entrenar(self, X, y, epocas=10):
        # Inserta una columna de 1s al final de X para tratar el sesgo
        # como un parámetro entrenable más dentro de la matriz de pesos
        X = np.c_[X, np.ones((X.shape[0]))]

        # Recorre el número de épocas indicado
        for epoca in np.arange(0, epocas):
            # Recorre cada punto de datos individual
            for (x, objetivo) in zip(X, y):
                # Producto punto entre entradas y pesos, pasado por la función escalón
                p = self.escalon(np.dot(x, self.W))

                # Actualiza los pesos solo si la predicción no coincide con el objetivo
                if p != objetivo:
                    error = p - objetivo
                    self.W += -self.alpha * error * x

    def predecir(self, X, agregar_sesgo=True):
        # Asegura que la entrada sea una matriz 2D
        X = np.atleast_2d(X)

        # Verifica si se debe agregar la columna del sesgo (1s)
        if agregar_sesgo:
            X = np.c_[X, np.ones((X.shape[0]))]

        # Calcula el producto punto y aplica la función escalón
        return self.escalon(np.dot(X, self.W))