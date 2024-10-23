import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;

public class JavaFileCreator {

    public static void main(String[] args) {
        // File chooser for gradle.properties file
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));  // Start at current directory
        fileChooser.setDialogTitle("Select gradle.properties File");

        // Filter for .properties files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Properties Files", "properties");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File gradleFile = fileChooser.getSelectedFile();

            // Ensure it's the gradle.properties file
            if (!gradleFile.getName().equals("gradle.properties")) {
                JOptionPane.showMessageDialog(null, "Please select the valid gradle.properties file.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Proceed with the rest of the logic (e.g., showing the mod creator GUI)
            showModCreatorGUI(gradleFile);
        } else {
            JOptionPane.showMessageDialog(null, "No file selected. Exiting program.");
            System.exit(0);
        }
    }

    // GUI for mod creation or copying from an existing source
    private static void showModCreatorGUI(File gradleFile) {
        // Setup GUI
        JFrame frame = new JFrame("Mod File Creator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        // Option to create a new mod or copy from existing source
        JLabel optionLabel = new JLabel("Choose Action:");
        panel.add(optionLabel);

        JRadioButton createNewModRadio = new JRadioButton("Create New Mod");
        JRadioButton copyExistingRadio = new JRadioButton("Copy from Existing Source");
        ButtonGroup actionGroup = new ButtonGroup();
        actionGroup.add(createNewModRadio);
        actionGroup.add(copyExistingRadio);
        createNewModRadio.setSelected(true);  // Default to "Create New Mod"
        panel.add(createNewModRadio);
        panel.add(copyExistingRadio);

        // Mod name input
        JLabel modNameLabel = new JLabel("Enter Mod Name: ");
        JTextField modNameField = new JTextField();
        panel.add(modNameLabel);
        panel.add(modNameField);

        // Username input with default value
        JLabel usernameLabel = new JLabel("Enter Username: ");
        JTextField usernameField = new JTextField("awesomeshot5051");
        panel.add(usernameLabel);
        panel.add(usernameField);

        // Create button
        JButton createButton = new JButton("Proceed");
        panel.add(new JLabel()); // Placeholder
        panel.add(createButton);

        frame.add(panel);
        frame.setVisible(true);

        // Action listener for the proceed button
        createButton.addActionListener(e -> {
            String modName = modNameField.getText().trim();
            String username = usernameField.getText().trim();

            if (modName.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Mod name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Convert mod name to camelCase
            String camelCaseModName = toCamelCase(modName);

            // Determine the action (create new mod or copy from existing)
            if (copyExistingRadio.isSelected()) {
                // File chooser for the existing source directory
                JFileChooser folderChooser = new JFileChooser(System.getProperty("user.dir"));
                folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                folderChooser.setDialogTitle("Select Existing Source Folder");

                int folderResult = folderChooser.showOpenDialog(null);
                if (folderResult == JFileChooser.APPROVE_OPTION) {
                    File sourceFolder = folderChooser.getSelectedFile();

                    // Merge the source folder contents into the project structure
                    try {
                        Path targetDir = Paths.get(System.getProperty("user.dir"));
                        Path sourceDir = sourceFolder.toPath();  // Use the selected source folder directly

                        // Get the parent directory of the selected folder three levels up
                        // Three directories up

                        // Copy and merge the source files into the target directory, updating mod name and username
                        copyAndMergeFolders(sourceDir, targetDir, camelCaseModName, username);

                        // Display success message
                        JOptionPane.showMessageDialog(frame, "Files copied and merged successfully.");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "Error copying files.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                // Default mod creation
                String directoryPath = "src/main/java/com/" + username + "/" + camelCaseModName;
                File directory = new File(directoryPath);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Create the new Java file
                String filePath = directoryPath + "/Main.java";
                try (FileWriter writer = new FileWriter(filePath)) {
                    writer.write(generateJavaFileContent(camelCaseModName, username));
                    JOptionPane.showMessageDialog(frame, "Java file created successfully at: " + filePath);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error creating Java file.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Modify gradle.properties file
                try {
                    modifyGradleProperties(gradleFile, camelCaseModName, username);
                    JOptionPane.showMessageDialog(frame, "gradle.properties modified successfully.");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error modifying gradle.properties file.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.setLocationRelativeTo(null);
    }

    // Method to convert a mod name to camelCase
    private static String toCamelCase(String modName) {
        String[] words = modName.split("\\s+");
        StringBuilder camelCaseModName = new StringBuilder(words[0].toLowerCase());

        for (int i = 1; i < words.length; i++) {
            camelCaseModName.append(Character.toUpperCase(words[i].charAt(0)))
                    .append(words[i].substring(1).toLowerCase());
        }

        return camelCaseModName.toString();
    }

    // Method to generate the content of the new Java file
    private static String generateJavaFileContent(String modName, String username) {
        return "package com." + username + "." + modName + ";\n\n" +
                "import net.neoforged.api.distmarker.Dist;\n" +
                "import net.neoforged.api.distmarker.OnlyIn;\n" +
                "import net.neoforged.bus.api.IEventBus;\n" +
                "import net.neoforged.fml.config.ModConfig;\n" +
                "import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;\n" +
                "import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;\n" +
                "import net.neoforged.fml.loading.FMLEnvironment;\n" +
                "import net.neoforged.neoforge.common.NeoForge;\n" +
                "import org.apache.logging.log4j.LogManager;\n" +
                "import org.apache.logging.log4j.Logger;\n" +
                "public class Main {\n\n" +
                "    public static final String MODID = \"" + modName + "\";\n" +
                "    public static final Logger LOGGER = LogManager.getLogger(MODID);\n" +
                "    //public static ServerConfig SERVER_CONFIG;\n" +
                "    //public static ClientConfig CLIENT_CONFIG;\n\n" +
                "    public Main(IEventBus eventBus) {\n" +
                "        eventBus.addListener(this::commonSetup);\n" +
                "        //SERVER_CONFIG = CommonRegistry.registerConfig(MODID, ModConfig.Type.SERVER, ServerConfig.class);\n" +
                "        //CLIENT_CONFIG = CommonRegistry.registerConfig(MODID, ModConfig.Type.CLIENT, ClientConfig.class);\n" +
                "        if (FMLEnvironment.dist.isClient()) {\n" +
                "            eventBus.addListener(Main.this::clientSetup);\n" +
                "            Containers.initClient(eventBus);\n" +
                "        }\n" +
                "    }\n\n" +
                "    public void commonSetup(FMLCommonSetupEvent event) {\n" +
                "        NeoForge.EVENT_BUS.register(new BlockEvents());\n" +
                "    }\n" +
                "    @OnlyIn(Dist.CLIENT)\n" +
                "    public void clientSetup(FMLClientSetupEvent event) {}\n" +
                "}";
    }

    // Method to modify gradle.properties file
    private static void modifyGradleProperties(@NotNull File gradleFile, String modName, String username) throws IOException {
        String modId = modName.replace(" ", "_").toLowerCase();
        String gradleContent = new String(Files.readAllBytes(gradleFile.toPath()));
        gradleContent = gradleContent.replaceAll("(?m)^mod_id=.*$", "mod_id=" + modId);
        gradleContent = gradleContent.replaceAll("(?m)^mod_author=.*$", "mod_author=" + username);
        Files.write(gradleFile.toPath(), gradleContent.getBytes());
    }

    private static void copyAndMergeFolders(Path source, Path targetParent, String newModName, String username) throws IOException {
        // Walk through the source directory
        Files.walk(source).forEach(sourcePath -> {
            // Determine relative path in the new project (target parent + relative source path)
            Path relativePath = source.relativize(sourcePath);
            Path targetPath = targetParent.resolve(relativePath);

            try {
                if (Files.isDirectory(sourcePath)) {
                    // Create directories in the target if they don't exist
                    Files.createDirectories(targetPath);
                } else {
                    // Copy files, replacing existing ones
                    Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (AccessDeniedException e) {
                // Skip files or directories we don't have access to
                System.err.println("Access denied to: " + sourcePath + ". Skipping...");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Now modify files as needed (e.g., update the mod name in the copied files)
        updateModFiles(targetParent, newModName, username);
    }

    private static void updateModFiles(Path targetParent, String modName, String username) throws IOException {
        // Example: Rename package paths, modify class names, or update config files, etc.
        Path mainJavaFile = targetParent.resolve("Main.java");
        if (Files.exists(mainJavaFile)) {
            String content = new String(Files.readAllBytes(mainJavaFile));
            content = content.replace("template_mod_id", modName.toLowerCase())
                    .replace("com.example.examplemod", "com." + username + "." + modName);
            Files.write(mainJavaFile, content.getBytes());
        }
    }

}
