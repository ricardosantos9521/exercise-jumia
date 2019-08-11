FROM node:carbon as build-node
WORKDIR /app
COPY package*.json ./
COPY tsconfig.json ./
RUN npm install
COPY . .
RUN npm run build

FROM httpd
COPY --from=build-node /app/build/ /usr/local/apache2/htdocs/
RUN echo "ServerName localhost" >> /usr/local/apache2/conf/httpd.conf