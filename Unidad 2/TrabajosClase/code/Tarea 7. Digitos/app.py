import os
import numpy as np
import tensorflow as tf
import gradio as gr
from PIL import Image

ruta_modelo = os.path.join(os.path.dirname(os.path.abspath(__file__)), "mlp_model.keras")
model = tf.keras.models.load_model(ruta_modelo)

def predecir_digito(dibujo):
    if dibujo is None:
        return {}

    # Compatibilidad con versiones recientes de Gradio Sketchpad
    if isinstance(dibujo, dict):
        dibujo = dibujo.get("composite", dibujo.get("image"))

    # 2. Convertir a escala de grises y redimensionar a 28x28
    imagen = Image.fromarray(dibujo.astype("uint8")).convert("L")
    imagen = imagen.resize((28, 28), Image.Resampling.LANCZOS)

    img_array = np.array(imagen, dtype="float32")

    # 3. Invertir colores si el fondo es claro (MNIST usa fondo negro = 0 y trazo blanco = 255)
    if np.mean(img_array) > 127:
        img_array = 255.0 - img_array

    # 4. Normalizar igual que en el entrenamiento y ajustar forma a (1, 28, 28)
    img_array = img_array / 255.0
    img_array = img_array.reshape(1, 28, 28)

    # 5. Realizar predicción
    predicciones = model.predict(img_array, verbose=0)[0]
    return {str(i): float(predicciones[i]) for i in range(10)}

# 6. Configurar y lanzar la interfaz
interfaz = gr.Interface(
    fn=predecir_digito,
    inputs=gr.Sketchpad(label="Dibuja un número del 0 al 9"),
    outputs=gr.Label(num_top_classes=3, label="Predicción del modelo"),
    title="Clasificador de Dígitos MNIST",
    description="Dibuja un dígito en el recuadro para clasificarlo usando el modelo entrenado."
)

if __name__ == "__main__":
    interfaz.launch()