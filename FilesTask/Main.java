package JavaCoreTasks.FilesTask;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Создаем строку для логов
        StringBuilder logs = new StringBuilder();
        //Создаем каталоги
        logs.append(createDir("E://Games/src"));
        logs.append(createDir("E://Games/res"));
        logs.append(createDir("E://Games/savegames"));
        logs.append(createDir("E://Games/temp"));
        logs.append(createDir("E://Games/src/main"));
        logs.append(createDir("E://Games/src/test"));
        logs.append(createDir("E://Games/res/drawables"));
        logs.append(createDir("E://Games/res/vectors"));
        logs.append(createDir("E://Games/res/icons"));
        //Создаем файлы
        logs.append(createFile("E://Games/src/main/Main.java"));
        logs.append(createFile("E://Games/src/main/Utils.java"));
        logs.append(createFile("E://Games/temp/temp.txt"));
        //Записываем в файл temp.txt логи
        String result = logs.toString();
        try (FileWriter writer = new FileWriter("E://Games/temp/temp.txt", false)) {
            writer.write(result);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        //Создаем экземпляры GameProgress
        GameProgress save1 = new GameProgress(100, 25, 99, 20.5);
        GameProgress save2 = new GameProgress(80, 50, 102, 180.1);
        GameProgress save3 = new GameProgress(40, 30, 105, 1.5);
        ArrayList<String> listFiles = new ArrayList<>();
        listFiles.add("E://Games/savegames/save3.dat");
        listFiles.add("E://Games/savegames/save2.dat");
        listFiles.add("E://Games/savegames/save1.dat");
        //Сохраняем в файлы
        save3.saveGame("E://Games/savegames/save3.dat", save3);
        save2.saveGame("E://Games/savegames/save2.dat", save2);
        save1.saveGame("E://Games/savegames/save1.dat", save1);
        //Архивируем
        if (save1.zipFiles("E://Games/savegames/zip.zip", listFiles)) {
            //Удаляем файлы вне архива
            for (String file : listFiles) {
                Path path = Paths.get(file);
                try {
                    Files.delete(path);
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    public static String createDir(String dirPath) {
        File dir = new File(dirPath);
        if (dir.mkdir()) {
            return LocalDateTime.now() + dirPath + " каталог был создан\n";
        } else {
            return LocalDateTime.now() + dirPath + " каталог не был создан\n";
        }
    }

    public static String createFile(String filePath) {
        File mainFile = new File(filePath);
        try {
            if (mainFile.createNewFile()) {
                return filePath + " файл был создан\n";
            } else {
                return filePath + " файл не был создан\n";
            }
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }
}
