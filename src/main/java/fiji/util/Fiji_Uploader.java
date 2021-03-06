package fiji.util;

import fiji.IJ1LogService;
import fiji.IJ1StatusService;
import ij.io.OpenDialog;
import ij.plugin.PlugIn;

import java.io.File;

import net.imagej.plugins.commands.upload.SampleImageUploader;

/**
 * A plugin to facilitate uploading files to the ImageJ dropbox.
 *
 * @author Johannes Schindelin
 */
public class Fiji_Uploader implements PlugIn {

	@Override
	public void run(String arg) {
		OpenDialog od = new OpenDialog("File to upload", arg);
		if (od.getDirectory() == null)
			return; // canceled

		File file = new File(od.getDirectory(), od.getFileName());
		SampleImageUploader.run(file, new IJ1StatusService(), new IJ1LogService());
	}
}
