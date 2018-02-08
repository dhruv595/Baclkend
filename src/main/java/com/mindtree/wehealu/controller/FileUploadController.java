package com.mindtree.wehealu.controller;

import java.io.File;
import org.apache.commons.codec.binary.Base64;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlob;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

import com.mindtree.wehealu.dto.UploadDTO;
import com.mindtree.wehealu.entity.UploadHistory;
import com.mindtree.wehealu.entity.User;
import com.mindtree.wehealu.service.PatientDetailsService;

@RestController
@CrossOrigin
public class FileUploadController extends HttpServlet {
	
	@Autowired
	PatientDetailsService patientDetailsService;
	public static final String storageConnectionString = "DefaultEndpointsProtocol=https;" + "AccountName=wehealunov;"
			+ "AccountKey=GxwhYS7Zz63HRr9zhemgHOh8QKs5Y4nTSXpo/sCL6+Z1MA6EiVv6Hk5LBzWf2DJ/BoTrBx+xII2Xkx8Nr9Umrg==";

	@RequestMapping(value = "/upload", consumes = "application/JSON", method = RequestMethod.POST)

	public void upload(@RequestBody UploadDTO testDTO)

	{

		System.out.println(testDTO.getFile_path());
		try {
			CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);
			CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

			CloudBlobContainer container = blobClient.getContainerReference("weheal");
			container.createIfNotExists();

			String base64Image = testDTO.getFile_path().split(",")[1];
			byte by[] = Base64.decodeBase64(base64Image);
			File a = new File(testDTO.getFile_name());
			FileOutputStream fos = new FileOutputStream(a);
			fos.write(by);
			CloudBlockBlob blob = container.getBlockBlobReference(testDTO.getFile_name());

			blob.upload(new FileInputStream(a), a.length());
			System.out.println("success");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/download", consumes = "application/json", method = RequestMethod.POST)
	public static void download(@RequestBody UploadDTO testDTO) {
		try {
			CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);
			CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
			CloudBlobContainer container = blobClient.getContainerReference("weheal");
			CloudBlockBlob blob = container.getBlockBlobReference(testDTO.getFile_name());
			String userName = System.getProperty("user.name");
			if (blob instanceof CloudBlob) {

				blob.download(new FileOutputStream(
						new FileOutputStream("C:\\Users\\" + userName + "\\Downloads\\") + blob.getName()));
				// //blob.download("C:\\Users\\" + userName + "\\Downloads\\" +
				// blob);
				// //blob.downloadToFile(new FileOutputStream("D:\\azure\\")
				// +blob.getName() );
				// blob.downloadToFile(new FileOutputStream("C:\\Users\\" +
				// userName + "\\Downloads\\")+blob.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/delete", consumes = "application/json", method = RequestMethod.POST)
	public void delete(@RequestBody UploadDTO testDTO) {
		try {
			CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);
			CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
			CloudBlobContainer container = blobClient.getContainerReference("weheal");
			CloudBlockBlob blob = container.getBlockBlobReference(testDTO.getFile_name());
			blob.deleteIfExists();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/uploadHistory", consumes = "application/json", method = RequestMethod.POST)	
	public void uploadHistory(@RequestBody User user)
	{
		patientDetailsService.uploadHistory(user);
		System.out.println(user);
		
	}
	
	@RequestMapping(value = "/getUploadHistory", consumes = "application/json", method = RequestMethod.POST)	
	public List<UploadHistory> getUploadHistory(@RequestBody User user)
	{
		return patientDetailsService.getUploadHistory(user);
		
		
	}
	@RequestMapping(value = "/deleteUploadHistory", consumes = "application/json", method = RequestMethod.POST)	
	public void deleteUploadHistory(@RequestBody User user)
	{
		System.out.println(user);
		patientDetailsService.deleteUploadHistory(user);
		
	}
}
