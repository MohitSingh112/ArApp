📱 ARApp — Drill Placement in Augmented Reality
ARApp is an Android application that uses ARCore and SceneView to let users practice object placement drills in Augmented Reality. Users can select from three drills (Basic, Advanced, Expert), each with a unique 3D model that can be placed on detected surfaces using their device's camera.

🧠 Features
🔍 Surface Detection: Automatically detects horizontal planes.

🎯 Drill Marker Placement: Tap to place drill markers on detected planes.

🧱 Model Variants:

Cube for Basic Drill

Cone for Advanced Drill

Sphere for Expert Drill

💡 Tips and Instructions: Contextual drill tips and placement instructions.

🔁 Replace Placement: Tap again to move the drill marker to a new location.

📁 Project Structure
plaintext
Copy
Edit
com.example.arapp/
├── MainActivity.kt             # Drill selection screen
├── DrillDetailActivity.kt     # Drill info and start AR experience
├── ARActivity.kt              # Main AR experience with model placement
├── res/
│   └── layout/
│       ├── activity_main.xml
│       ├── activity_drill_detail.xml
│       └── activity_ar.xml
├── assets/
│   └── models/
│       ├── cube.glb
│       ├── cone.glb
│       └── sphere.glb
🚀 Getting Started
Prerequisites
Android Studio Electric Eel or newer

Android device that supports ARCore

minSdk 24 and targetSdk 35

Internet access (fallback models load from GitHub)

Dependencies
kotlin
Copy
Edit
implementation 'com.google.ar:core:1.41.0'
implementation 'io.github.sceneview:arsceneview:0.10.0'
Setup
Clone the repo or copy the source files into your Android Studio project.

Place your .glb models in src/main/assets/models/.

Connect an ARCore-supported device.

Build & Run on the device.

🎮 Usage
Launch the app.

Select a drill type from the dropdown.

Read the drill instructions.

Tap “Start AR Drill”.

Scan for a surface.

Tap to place your marker model.

📸 Screenshots
(You can add screenshots here later to illustrate UI and AR views.)

📦 Fallbacks
If the .glb model fails to load from assets, the app loads a primitive shape from:

📦 Khronos glTF Sample Models Repository

🛠️ Troubleshooting
✅ Ensure Google Play Services for AR is installed and up to date.

✅ Grant camera permission at runtime.

✅ Use an ARCore-compatible device.

❌ Not compatible with emulators.

📄 License
This project is for educational/demo purposes. You can adapt and expand upon it freely.
