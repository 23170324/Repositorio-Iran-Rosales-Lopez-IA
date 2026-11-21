from Perceptron import Perceptron
import numpy as np

# Construye el conjunto de datos AND
X = np.array([[0, 0], [0, 1], [1, 0], [1, 1]])
y = np.array([[0], [0], [0], [1]])

# Define el perceptrón y lo entrena
print("[INFO] entrenando perceptrón...")
p = Perceptron(X.shape[1], alpha=0.1)
p.entrenar(X, y, epocas=20)

# Evalúa el perceptrón ya entrenado
print("[INFO] probando perceptrón...")
for (x, objetivo) in zip(X, y):
    prediccion = p.predecir(x)
    print(f"[INFO] entrada={x}, valor_real={objetivo[0]}, prediccion={prediccion}")