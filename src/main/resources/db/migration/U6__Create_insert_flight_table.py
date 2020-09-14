from sqlalchemy import create_engine
from sqlalchemy.orm import scoped_session, sessionmaker

# creation of an engine
engine = create_engine("postgresql://postgres:postgres@localhost:5432/postgres")
# creation of a session
db = scoped_session(sessionmaker(bind=engine))
# creation of the table flights with all the attributes
db.execute("DROP TABLE flights;")
# commit the changes
db.commit()
# close the session
db.close()
