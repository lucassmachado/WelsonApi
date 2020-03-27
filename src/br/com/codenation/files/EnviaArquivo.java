package br.com.codenation.files;

import java.io.File;

import org.apache.hc.client5.http.entity.mime.FileBody;
import org.apache.hc.client5.http.entity.mime.HttpMultipartMode;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.entity.mime.StringBody;
import org.apache.hc.core5.http.ContentType;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;




public class EnviaArquivo {

	
	public void EnviaArquivo() {
		File file = new File("C:\\programas\\loucademia\\JavaFundamentos\\Codenation1\\answer.json");

		HttpPost post = new HttpPost("https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=814858516cd676572b4d77dfea079ef8111e6098");

		//File file = new File(textFileName);

		//HttpPost post = new HttpPost("http://echo.200please.com");

		FileBody fileBody = new FileBody(file, ContentType.DEFAULT_BINARY);

		StringBody stringBody1 = new StringBody("Message 1", ContentType.MULTIPART_FORM_DATA);

		StringBody stringBody2 = new StringBody("Message 2", ContentType.MULTIPART_FORM_DATA);

		//

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();

		builder.setMode(HttpMultipartMode.EXTENDED);

		builder.addPart("upfile", fileBody);

		builder.addPart("text1", stringBody1);

		builder.addPart("text2", stringBody2);

		HttpEntity entity = (HttpEntity) builder.build();

		//

		post.setEntity(entity);

		
		//HttpResponse response = client.execute(post);
	}
}
