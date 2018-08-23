FROM python:3.6

WORKDIR /app

COPY ./requirements.txt /app
RUN pip install -r requirements.txt

COPY ./ /app

ENV FLASK_APP app.py
EXPOSE 5000

CMD [ "flask", "run", "-h", "0.0.0.0" ]