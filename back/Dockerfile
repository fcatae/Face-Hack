FROM python:3.6.6-slim-stretch

WORKDIR /app

COPY requirements.txt .

RUN pip3 install -r requirements.txt

COPY . .

EXPOSE 5000

CMD [ "python3", "server.py" ]