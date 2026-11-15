# Backend Doc

Dentro de la carpeta Backend, hay una carpeta llamada loadBackend, la cual se encarga de cargar determinados componentes del backend necesarios para el funcionamiento del lanzador.

La clase principal es la clase StartConfig que esta se ejecuta el iniciar el launcher y es la encargada de ejecutar todas las clases de esta misma carpeta
# -loadBackend (folder)

There are several files here; the least important one is `VersionsManifestModel`, which is simply used to receive the JSON from the Mojang API.

# ConfigFiles

Minecraft has a file system where important game data is stored; this system is responsible for creating the folder if it does not exist or if any files are missing.

# MojangService

This is one of the most important components, as it serves as the first step toward downloading game versions. It connects directly to the Mojang API, retrieves the "version manifest," and saves this information into a local .json file—which is only updated whenever there is a new game release.

This is crucial because the version manifest contains links to individual .json files, each of which provides specific details about a selected version, including its corresponding download link.

# StartConfig

As mentioned earlier, this component is responsible for executing all the classes in this folder—along with anything else that needs to run immediately upon launching the application—after which it finishes its task and hands control over to the rest of the program.