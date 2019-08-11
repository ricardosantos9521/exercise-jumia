To boot the project:

    - Build the images in root folder:
       - docker build -t exercise-be java/
       - docker build -t exercise-fe react/

    - Run the images
       - docker run -d -p8080:8080 exercise-be 
       - docker run -d -p80:80 exercise-fe 

    - Stop containers
       - docker stop $(docker ps -q --filter ancestor=exercise-be )
       - docker stop $(docker ps -q --filter ancestor=exercise-fe )