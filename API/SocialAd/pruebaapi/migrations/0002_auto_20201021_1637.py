# Generated by Django 2.2.12 on 2020-10-21 16:37

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('pruebaapi', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='cliente',
            name='apellido_cliente',
            field=models.CharField(blank=True, default='', max_length=200),
        ),
        migrations.AddField(
            model_name='cliente',
            name='nombre_cliente',
            field=models.CharField(blank=True, default='', max_length=200),
        ),
        migrations.AlterField(
            model_name='cita',
            name='id_cliente',
            field=models.ForeignKey(db_column='id_cliente', on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.Cliente'),
        ),
        migrations.AlterField(
            model_name='cita',
            name='id_comercio',
            field=models.ForeignKey(db_column='id_comercio', on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.Comercio'),
        ),
        migrations.AlterField(
            model_name='cita',
            name='id_estado_cita',
            field=models.ForeignKey(db_column='id_estado_cita', on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.EstadoCita'),
        ),
        migrations.AlterField(
            model_name='cita',
            name='id_horario',
            field=models.ForeignKey(db_column='id_horario', on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.Horario'),
        ),
        migrations.AlterField(
            model_name='cliente',
            name='id_municipio',
            field=models.ForeignKey(db_column='id_municipio', on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.Municipio'),
        ),
        migrations.AlterField(
            model_name='clientexcola',
            name='id_cliente',
            field=models.ForeignKey(db_column='id_cliente', on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.Cliente'),
        ),
        migrations.AlterField(
            model_name='clientexcola',
            name='id_cola',
            field=models.ForeignKey(db_column='id_cola', on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.Cola'),
        ),
        migrations.AlterField(
            model_name='cola',
            name='id_comercio',
            field=models.ForeignKey(db_column='id_comercio', on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.Comercio'),
        ),
        migrations.AlterField(
            model_name='cola',
            name='id_tipo_cola',
            field=models.ForeignKey(db_column='id_tipo_cola', on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.TipoCola'),
        ),
        migrations.AlterField(
            model_name='cola',
            name='id_tipo_servicio',
            field=models.ForeignKey(db_column='id_tipo_servicio', on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.TipoServicio'),
        ),
        migrations.AlterField(
            model_name='comercio',
            name='id_capacidad',
            field=models.ForeignKey(blank=True, db_column='id_capacidad', null=True, on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.CapacidadComercio'),
        ),
        migrations.AlterField(
            model_name='comercio',
            name='id_municipio',
            field=models.ForeignKey(blank=True, db_column='id_municipio', null=True, on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.Municipio'),
        ),
        migrations.AlterField(
            model_name='comercio',
            name='id_tipocomercio',
            field=models.ForeignKey(blank=True, db_column='id_tipocomercio', null=True, on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.TipoComercio'),
        ),
        migrations.AlterField(
            model_name='comercioxnormativa',
            name='id_comercio',
            field=models.ForeignKey(db_column='id_comercio', on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.Comercio'),
        ),
        migrations.AlterField(
            model_name='comercioxnormativa',
            name='id_normativa',
            field=models.ForeignKey(db_column='id_normativa', on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.Normativa'),
        ),
        migrations.AlterField(
            model_name='comercioxtiposervicio',
            name='id_comercio',
            field=models.ForeignKey(db_column='id_comercio', on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.Comercio'),
        ),
        migrations.AlterField(
            model_name='comercioxtiposervicio',
            name='id_tiposervicio',
            field=models.ForeignKey(db_column='id_tiposervicio', on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.TipoServicio'),
        ),
        migrations.AlterField(
            model_name='horarioxcomercio',
            name='id_comercio',
            field=models.ForeignKey(db_column='id_comercio', on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.Comercio'),
        ),
        migrations.AlterField(
            model_name='horarioxcomercio',
            name='id_horario',
            field=models.ForeignKey(db_column='id_horario', on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.Horario'),
        ),
        migrations.AlterField(
            model_name='municipio',
            name='id_departamento',
            field=models.ForeignKey(db_column='id_departamento', on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.Departamento'),
        ),
        migrations.AlterField(
            model_name='normativa',
            name='id_tipo_normativa',
            field=models.ForeignKey(db_column='id_tipo_normativa', on_delete=django.db.models.deletion.CASCADE, to='pruebaapi.TipoNormativa'),
        ),
    ]
