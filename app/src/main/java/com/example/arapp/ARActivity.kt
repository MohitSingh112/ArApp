package com.example.arapp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.core.Config
import com.google.ar.core.Plane
import io.github.sceneview.ar.ArSceneView
import io.github.sceneview.ar.node.ArModelNode

class ARActivity : AppCompatActivity() {

    private lateinit var arSceneView: ArSceneView
    private lateinit var instructionText: TextView
    private var drillIndex: Int = 0
    private var placedAnchorNode: ArModelNode? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ar)

        drillIndex = intent.getIntExtra("DRILL_INDEX", 0)

        setupViews()
        setupARScene()
    }

    private fun setupViews() {
        arSceneView = findViewById(R.id.arSceneView)
        instructionText = findViewById(R.id.instructionText)

        // Set initial instruction text
        instructionText.text = "Tap on ground to place drill marker"
    }

    private fun setupARScene() {
        arSceneView.apply {
            configureSession { session, config ->
                config.depthMode = Config.DepthMode.AUTOMATIC
                config.instantPlacementMode = Config.InstantPlacementMode.LOCAL_Y_UP
                config.lightEstimationMode = Config.LightEstimationMode.ENVIRONMENTAL_HDR
            }

            onTapAr = { hitResult, motionEvent ->
                val hitPlane = hitResult.trackable as? Plane

                if (hitPlane != null && hitPlane.type == Plane.Type.HORIZONTAL_UPWARD_FACING) {
                    placeObject(hitResult)
                }
            }
        }
    }

    private fun placeObject(hitResult: com.google.ar.core.HitResult) {
        // Remove existing object if any
        placedAnchorNode?.let {
            arSceneView.removeChild(it)
            it.anchor = null
            it.destroy()
        }

        val modelNode = ArModelNode(arSceneView.engine).apply {
            anchor = hitResult.createAnchor()

            // Load different models based on drill type
            when (drillIndex) {
                0 -> {
                    // Red Cube for Basic Drill
                    loadModelGlbAsync(
                        glbFileLocation = "models/cube.glb",
                        autoAnimate = false,
                        scaleToUnits = 0.1f,
                        centerOrigin = null
                    ) { modelInstance ->
                        if (modelInstance == null) {
                            createPrimitiveModel("cube")
                        } else {
                            Toast.makeText(this@ARActivity, "Cube marker placed!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                1 -> {
                    // Green Cone for Advanced Drill
                    loadModelGlbAsync(
                        glbFileLocation = "models/cone.glb",
                        autoAnimate = false,
                        scaleToUnits = 0.15f,
                        centerOrigin = null
                    ) { modelInstance ->
                        if (modelInstance == null) {
                            createPrimitiveModel("cone")
                        } else {
                            Toast.makeText(this@ARActivity, "Cone marker placed!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                2 -> {
                    // Blue Sphere for Expert Drill
                    loadModelGlbAsync(
                        glbFileLocation = "models/sphere.glb",
                        autoAnimate = false,
                        scaleToUnits = 0.08f,
                        centerOrigin = null
                    ) { modelInstance ->
                        if (modelInstance == null) {
                            createPrimitiveModel("sphere")
                        } else {
                            Toast.makeText(this@ARActivity, "Sphere marker placed!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

        arSceneView.addChild(modelNode)
        placedAnchorNode = modelNode

        instructionText.text = "Tap on another location to move the marker"
    }

    private fun ArModelNode.createPrimitiveModel(type: String) {
        // Fallback to basic colored shapes if model files not found
        when (type) {
            "cube" -> {
                // Create a simple cube with basic material
                loadModelGlbAsync(
                    glbFileLocation = "https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/Box/glTF-Binary/Box.glb",
                    autoAnimate = false,
                    scaleToUnits = 0.1f,
                    centerOrigin = null
                )
            }
            "cone" -> {
                // Use cylinder as cone alternative
                loadModelGlbAsync(
                    glbFileLocation = "https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/Cylinder/glTF-Binary/Cylinder.glb",
                    autoAnimate = false,
                    scaleToUnits = 0.15f,
                    centerOrigin = null
                )
            }
            "sphere" -> {
                loadModelGlbAsync(
                    glbFileLocation = "https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/Sphere/glTF-Binary/Sphere.glb",
                    autoAnimate = false,
                    scaleToUnits = 0.08f,
                    centerOrigin = null
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        // ArSceneView handles lifecycle automatically in newer versions
    }

    override fun onPause() {
        super.onPause()
        // ArSceneView handles lifecycle automatically in newer versions
    }

    override fun onDestroy() {
        super.onDestroy()
        arSceneView.destroy()
    }
}