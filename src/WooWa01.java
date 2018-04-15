import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.util.Collections.addAll;

public class WooWa01 {

    class ImageName {

        private String name ="";
        private String extention = "";
        private String city = "";
        private LocalDateTime dateTime;
        private int sequence;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getExtention() {
            return extention;
        }

        public void setExtention(String extention) {
            this.extention = extention;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public LocalDateTime getDateTime() {
            return dateTime;
        }

        public void setDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
        }

        public int getSequence() {
            return sequence;
        }

        public void setSequence(int sequence) {
            this.sequence = sequence;
        }


    }
    public String WooWa01 (String S) {



        String [] inputStrArr = S.split("\n");
        ArrayList<ImageName> imageList = new ArrayList<>();

        for (String inputStr :
                inputStrArr) {

            String [] forImageNameArr = inputStr.split(",");

            ImageName imageName = new ImageName();
            imageName.setName(forImageNameArr[0].substring(0, forImageNameArr[0].indexOf(".")));
            imageName.setExtention(forImageNameArr[0].substring(forImageNameArr[0].indexOf(".")+1, forImageNameArr[0].length()));
            imageName.setCity(forImageNameArr[1].substring(1, forImageNameArr[1].length()));
            imageName.setDateTime(LocalDateTime.parse(
                    forImageNameArr[2].substring(1, forImageNameArr[2].length()), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            imageList.add(imageName);

        }

        ArrayList<ImageName>forSort = new ArrayList<>();
        forSort.addAll(imageList);

        Collections.sort(forSort, new Comparator<ImageName>() {
            @Override
            public int compare(ImageName o1, ImageName o2) {


                    if(o1.dateTime.isBefore(o2.getDateTime())) {
                        return -1;
                    } else if (o1.dateTime.isAfter(o2.getDateTime())){
                        return 1;
                    } else {
                        return 0;
                    }
            }
        });

        Map<String, Integer> forSeq = new HashMap<>();

    for (ImageName imageName:
             forSort) {


            String cityName = imageName.getCity();
            if(forSeq.containsKey(cityName)) {

                imageName.setSequence(forSeq.get(cityName)+1);
                forSeq.replace(cityName, forSeq.get(cityName)+1);
            } else {
                imageName.setSequence(1);
                forSeq.put(cityName, 1);
            }
        }


        StringBuilder result = new StringBuilder("");
        for (ImageName imageName :
                imageList) {

            String tempName = imageName.getName();
            String tempCity = imageName.getCity();
            String tempExtention = imageName.getExtention();

            int numOfZero = forSeq.get(tempCity) / 10 +1;

            for(ImageName tempImageName : forSort) {

                if(tempImageName.getName().equals(tempName) &&
                        tempImageName.getCity().equals(tempCity) &&
                        tempImageName.getExtention().equals(tempExtention)) {

                    imageName.setSequence(tempImageName.getSequence());
                }
            }

            result.append(imageName.getCity());
            result.append(String.format("%0"+numOfZero+"d", imageName.getSequence()));
            result.append("."+imageName.getExtention()+"\n");



        }

        return result.toString();
    }
}
