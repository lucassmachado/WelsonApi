package br.com.codenation.files;

import java.io.File;
import java.io.IOException;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.FileBody;
import org.apache.hc.client5.http.entity.mime.HttpMultipartMode;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.entity.mime.StringBody;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpResponse;

public class EnviaArquivo {

	//TODO: nome de método nunca deve ser o mesmo nome da classe (coisa básica hein...)
	public void EnviaArquivo() {
		File file = new File(
				"C:/Desenvolvimento/workspaceAwb30/WelsonApi/answer.json");
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(
				"https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=814858516cd676572b4d77dfea079ef8111e6098");

		// File file = new File(textFileName);

		// HttpPost post = new HttpPost("http://echo.200please.com");

		FileBody fileBody = new FileBody(file, ContentType.DEFAULT_BINARY);

		StringBody stringBody1 = new StringBody("Message 1",
				ContentType.MULTIPART_FORM_DATA);

		StringBody stringBody2 = new StringBody("Message 2",
				ContentType.MULTIPART_FORM_DATA);

		//

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();

		builder.setMode(HttpMultipartMode.EXTENDED);

		builder.addPart("upfile", fileBody);

		builder.addPart("text1", stringBody1);

		builder.addPart("text2", stringBody2);

		HttpEntity entity = (HttpEntity) builder.build();

		//

		post.setEntity(entity);

		try {
			HttpResponse response = client.execute(post);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
