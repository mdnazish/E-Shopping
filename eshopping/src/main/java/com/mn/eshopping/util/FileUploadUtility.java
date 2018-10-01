package com.mn.eshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABSOLUTE_PATH = "E:\\Spring_Projects\\E-Shopping\\eshopping\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = "";
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);

	/*
	 * It is used to upload a file/image in the DB & Project directory
	 */
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {

		// get the real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");

		logger.info(REAL_PATH);

		// Simple check to make sure all the directory exists,
		// otherwise create the directories
		if (!new File(ABSOLUTE_PATH).exists()) {

			// create the directories
			new File(ABSOLUTE_PATH).mkdirs();
		}
		if (!new File(REAL_PATH).exists()) {

			// create the directories
			new File(REAL_PATH).mkdirs();
		}

		try {
			// to server upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));

			// to project directory upload
			file.transferTo(new File(ABSOLUTE_PATH + code + ".jpg"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
