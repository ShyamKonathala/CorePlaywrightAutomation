package utils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;

public class FileUtils {
	
	 /**
     * Waits for a file download triggered by the given action, then saves it to the specified folder.
     *
     * @param page            The Playwright Page instance
     * @param downloadTrigger The action that triggers the download (e.g., clicking a button)
     * @return The path where the file was saved
     * @throws IOException if saving the file fails
     */
    public static Path downloadFile(Page page, Runnable downloadTrigger) throws IOException {
        // Wait for the download event
        Download download = page.waitForDownload(downloadTrigger);

        // Destination folder
        String downloadDir = "C:\\Users\\kshyamsai\\OneDrive - hsconline\\Documents\\";

        // Create the destination path with suggested filename
        Path destination = Paths.get(downloadDir + download.suggestedFilename());

        // Save the file to the destination
        download.saveAs(destination);

        System.out.println("File saved to: " + destination.toAbsolutePath());
        return destination;
    }
	
}
