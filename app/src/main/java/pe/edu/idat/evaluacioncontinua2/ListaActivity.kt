package pe.edu.idat.evaluacioncontinua2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.idat.evaluacioncontinua2.databinding.ActivityListaBinding

class ListaActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityListaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val testsPsicologicos = generarTestsPsicologicos()
        val testsMostrados = seleccionarTestsAleatorios(testsPsicologicos)

        binding.rvElementos.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvElementos.adapter = AdapterItem(testsMostrados)

        binding.tbActivityListaTP.setOnClickListener(this)
    }

    private fun generarTestsPsicologicos(): List<TestPsicologico> {
        val lista = ArrayList<TestPsicologico>()
        lista.add(TestPsicologico("Test de Personalidad MMPI-2", "Evalúa la personalidad y los posibles trastornos psicológicos", "1989"))
        lista.add(TestPsicologico("Test de Coeficiente Intelectual WAIS-IV", "Mide la inteligencia general y las habilidades cognitivas en adultos", "2008"))
        lista.add(TestPsicologico("Test de Rorschach", "Evalúa la personalidad y el funcionamiento mental a través de la interpretación de manchas de tinta", "1921"))
        lista.add(TestPsicologico("Test de Apercepción Temática (TAT)", "Evalúa la personalidad y las necesidades inconscientes a través de la interpretación de imágenes", "1935"))
        lista.add(TestPsicologico("Test de las Pirámides de Color (Pfister)", "Evalúa la personalidad y las emociones a través de la elección de colores y formas", "1921"))
        lista.add(TestPsicologico("Test de la Figura Humana", "Evalúa la personalidad, el estado emocional y la autoestima a través del dibujo de una figura humana", "1948"))
        lista.add(TestPsicologico("Test del Árbol", "Evalúa la personalidad, las emociones y la autoestima a través del dibujo de un árbol", "1948"))
        lista.add(TestPsicologico("Test de la Casa-Árbol-Persona (HTP)", "Evalúa la personalidad, las emociones y las relaciones interpersonales a través del dibujo de una casa, un árbol y una persona", "1948"))
        lista.add(TestPsicologico("Test de Bender", "Evalúa la percepción visual, la motricidad fina y la coordinación visomotora", "1938"))
        lista.add(TestPsicologico("Test de Raven", "Evalúa la inteligencia general y la capacidad de razonamiento abstracto", "1938"))
        lista.add(TestPsicologico("Test de Stroop", "Evalúa la atención selectiva, la flexibilidad cognitiva y el control inhibitorio", "1935"))
        lista.add(TestPsicologico("Test de Wisconsin Card Sorting Test (WCST)", "Evalúa la flexibilidad cognitiva, la capacidad de abstraer y la toma de decisiones", "1948"))
        lista.add(TestPsicologico("Test de Torre de Hanoi", "Evalúa la planificación, la resolución de problemas y la capacidad de pensar estratégicamente", "1975"))
        lista.add(TestPsicologico("Test de Trail Making Test (TMT)", "Evalúa la atención, la velocidad de procesamiento y la flexibilidad cognitiva", "1944"))
        lista.add(TestPsicologico("Test de Batería de Evaluación Neuropsicológica (NEPSY)", "Evalúa una amplia gama de funciones cognitivas en niños y adultos", "1989"))
        lista.add(TestPsicologico("Test de Escala de Inteligencia Wechsler para Niños (WISC-V)", "Mide la inteligencia general y las habilidades cognitivas en niños", "2014"))
        lista.add(TestPsicologico("Test de Escala de Inteligencia de Stanford-Binet (SB5)", "Mide la inteligencia general y las habilidades cognitivas en niños y adultos", "2003"))
        lista.add(TestPsicologico("Test de Inventario Multifásico de Personalidad de California (IPI)", "Evalúa la personalidad y los posibles trastornos psicológicos", "1956"))
        lista.add(TestPsicologico("Test de Cuestionario de Personalidad 16PF", "Evalúa la personalidad a través de 16 factores", "1949"))
        lista.add(TestPsicologico("Test de NEO-FFI (Inventario NEO de los Cinco Grandes Factores)", "Evalúa la personalidad a través de los cinco grandes factores: neuroticismo, extraversión, apertura a la experiencia, agradabilidad y responsabilidad", "1985"))
        return lista
    }

    private fun seleccionarTestsAleatorios(tests: List<TestPsicologico>): List<TestPsicologico> {
        return tests.shuffled().take(10)
    }

    data class TestPsicologico(val titulo: String, val descripcionCorta: String, val fechaPublicacion: String)

    override fun onClick(v0: View?) {
        if (v0?.id == binding.tbActivityListaTP.id) {
            onBackPressed()
        }
    }
}