 public class AppUtils {
 
 
 public static MultipartBody.Part prepareFilePart(Context con , String partName, Uri fileUri) {
        String filePath = DocumentHelper.getPath(con, fileUri);
        //Safety check to prevent null pointer exception
        if (filePath == null || filePath.isEmpty()) return null;
        File file = new File(filePath);
        ContentResolver cr = con.getContentResolver();
                String type = getMimeType(filePath);
        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(
                        MediaType.parse(type),
                        file
                );

        // MultipartBody.Part is used to send also the actual file name
        return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
    }


    // url = file path or whatever suitable URL you want.
    public static String getMimeType(String url) {
        String type = null;
        String extension = MimeTypeMap.getFileExtensionFromUrl(url);
        if (extension != null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        }
        return type;
    }
  }
