# 📱 ARApp — Drill Placement in Augmented Reality

**ARApp** is an Android application that uses **ARCore** and **SceneView** to let users practice object placement drills in Augmented Reality. Users can select from three drills (Basic, Advanced, Expert), each with a unique 3D model that can be placed on detected surfaces using their device's camera.

---

## 🧠 Features

- 🔍 **Surface Detection**: Automatically detects horizontal planes.
- 🎯 **Drill Marker Placement**: Tap to place drill markers on detected planes.
- 🧱 **Model Variants**:
  - 🟥 **Cube** for Basic Drill
  - 🟩 **Cone** for Advanced Drill
  - 🟦 **Sphere** for Expert Drill
- 💡 **Tips and Instructions**: Contextual drill tips and placement instructions.
- 🔁 **Replace Placement**: Tap again to move the drill marker to a new location.

---

## 📁 Project Structure


```
com.example.arapp/
├── MainActivity.kt # Drill selection screen
├── DrillDetailActivity.kt # Drill info and start AR experience
├── ARActivity.kt # Main AR experience with model placement
├── res/
│ └── layout/
│ ├── activity_main.xml
│ ├── activity_drill_detail.xml
│ └── activity_ar.xml
├── assets/
│ └── models/
│ ├── cube.glb
│ ├── cone.glb
│ └── sphere.glb

```

---

## 🚀 Getting Started

### Prerequisites

- ✅ Android Studio Electric Eel or newer
- ✅ Android device that supports ARCore
- ✅ Internet connection (for fallback models)
- ✅ Minimum SDK version: 24

---

## 🔧 Installation

1. Clone this repository or copy the code into your Android Studio project.
2. Create the following directory and place your 3D models:


```
app/src/main/assets/models/
├── cube.glb
├── cone.glb
└── sphere.glb

```

3. Open the project in Android Studio.
4. Connect an ARCore-supported device.
5. Build and run the app.

---

## 📦 Dependencies

In your `build.gradle.kts`:

```
implementation("com.google.ar:core:1.41.0")
implementation("io.github.sceneview:arsceneview:0.10.0")

```

---

## 🎮 How to Use

Launch the app.

1. Select a drill from the dropdown:

Drill 1: Basic Placement (Cube)

Drill 2: Advanced Placement (Cone)

Drill 3: Expert Placement (Sphere)

2. Read the instructions.

3. Tap Start AR Drill.

4. Move your phone slowly to detect a horizontal surface.

5. Tap to place a marker.

6. Tap again to move the marker to a new location.

---

## 🌐 Fallback Models

If the app fails to load the local .glb model, it fetches a fallback from the Khronos glTF Sample Models repository:

cube.glb → Cube

cone.glb → Cone

Sphere.glb → Sphere

---

## 🛠️ Troubleshooting

✅ Make sure Google Play Services for AR is installed and updated.

✅ Grant Camera Permission at runtime.

✅ Only run on physical Android devices (not emulators).

🔄 If models aren't showing:

Double-check file names: cube.glb, cone.glb, sphere.glb

Verify they are in src/main/assets/models/

---

## 📄 License

This project is provided for educational and demo purposes. You are free to modify and use it with proper attribution.

Created with ❤️ using ARCore, SceneView, and Kotlin

---
