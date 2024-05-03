FROM alpine
LABEL name="my_app"
WORKDIR /www/server
COPY . .
EXPOSE 8000
RUN apk add python3-dev &&\
    apk add py3-pip &&\
    apk add gcc &&\
    apk add libc-dev &&\
    apk add build-base
RUN pip install -r requirements.txt --no-cache-dir --break-system-packages
CMD ["python3", "main.py"]
