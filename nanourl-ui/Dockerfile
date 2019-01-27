# Stage 1 - Build web application from source code
FROM node:10-alpine as build-deps
# Create app directory
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
# Install app dependencies
COPY package.json /usr/src/app/
RUN npm install
# Copy app source into app directory
COPY . /usr/src/app
RUN npm run build

# Stage 2 - Build the production environment
FROM nginx:1.15-alpine
COPY --from=build-deps /usr/src/app/build /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
