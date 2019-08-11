docker build -t exercise-be java/
docker build -t exercise-fe react/
docker run -d -p8080:8080 exercise-be
docker run -d -p80:80 exercise-fe