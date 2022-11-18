package com.crud.File;
import com.crud.bean.BoardVO;
import com.crud.dao.BoardDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileUpload {
    public BoardVO uploadPhoto(HttpServletRequest request) {
        String filename = "";
        int sizeLimit = 15 * 1024 * 1024;

        String realPath =  request.getServletContext().getRealPath("upload");
        File dir = new File(realPath);
        if (!dir.exists()) dir.mkdirs();

        BoardVO one = null;
        MultipartRequest multipartRequest = null;
        try {
            multipartRequest = new MultipartRequest(request, realPath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
            filename = multipartRequest.getFilesystemName("photo");
            one = new BoardVO();
            String seq = multipartRequest.getParameter("seq");
            if (seq != null && !seq.equals(""))
                one.setSeq(Integer.parseInt(seq));

            one.setNAME(multipartRequest.getParameter("NAME"));
            one.setTeam(multipartRequest.getParameter("team"));
            one.setGoal(Integer.parseInt(multipartRequest.getParameter("goal")));
            one.setAssist(Integer.parseInt(multipartRequest.getParameter("assist")));
            one.setPoint(Integer.parseInt(multipartRequest.getParameter("point")));
            one.setShoot(Integer.parseInt(multipartRequest.getParameter("shoot")));
            one.setPlay(Integer.parseInt(multipartRequest.getParameter("play")));
            one.setPosition(multipartRequest.getParameter("position"));
            if (seq != null && !seq.equals("")) {
                BoardDAO dao = new BoardDAO();
                String oldfilename = dao.getPhotoFilename(Integer.parseInt(seq));
                if (filename != null && oldfilename != null)
                    FileUpload.deleteFile(request, oldfilename);
                else if (filename == null && oldfilename != null)
                    filename = oldfilename;
            }
            one.setPhoto(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return one;
    }

    public static void deleteFile(HttpServletRequest request, String filename){
        String filepath=request.getServletContext().getRealPath("/upload");

        File f= new File(filepath+"/"+filename);
        if(f.exists()) f.delete();
    }
}
